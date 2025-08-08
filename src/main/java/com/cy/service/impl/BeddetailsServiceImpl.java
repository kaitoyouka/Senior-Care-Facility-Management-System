package com.cy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cy.domain.Bed;
import com.cy.domain.Beddetails;
import com.cy.domain.Customer;
import com.cy.dto.BeddetailsDto;
import com.cy.dto.ExchangeDto;
import com.cy.mapper.BedMapper;
import com.cy.mapper.BeddetailsMapper;
import com.cy.mapper.CustomerMapper;
import com.cy.service.IBeddetailsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cy.utils.ResultVo;
import com.cy.vo.BedDetailsVo;
import com.cy.vo.CountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ChadYang
 * @since 2025-06-25
 */
@Service
@Transactional
public class BeddetailsServiceImpl extends ServiceImpl<BeddetailsMapper, Beddetails> implements IBeddetailsService {
    @Autowired
    private BeddetailsMapper beddetailsMapper;
    @Autowired
    private BedMapper bedMapper;
    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public ResultVo selectBedDetailsVo(BeddetailsDto beddetailsDto) {
        Map<String, Object> map = new HashMap<>();
        map.put("current", beddetailsDto.getCurrentPage());
        beddetailsDto.setCurrentPage((beddetailsDto.getCurrentPage() - 1) * beddetailsDto.getPageSize());
        List<BedDetailsVo> bedDetailsVoList = beddetailsMapper.selectBedDetailsVo(beddetailsDto);
        CountVo countVo = beddetailsMapper.selectCountVo(beddetailsDto);
        map.put("records", bedDetailsVoList);
        map.put("size", beddetailsDto.getPageSize());
        map.put("total", countVo.getCount());
        map.put("pages", Math.ceil((double) countVo.getCount() / beddetailsDto.getPageSize()));
        return ResultVo.ok(map);
    }

    @Override
    public ResultVo exchangeBed(ExchangeDto exchangeDto) {
        // 1.查询床位是否有人
//        LambdaQueryWrapper<Bed> lqw = new LambdaQueryWrapper<>();
        Bed bed = bedMapper.selectById(exchangeDto.getNewBedId());
        if (bed.getBedStatus() != 1) {
            return ResultVo.fail("该床位已有人");
        }
        // 2.修改客户旧床位详情信息：is_deleted = 1 床位使用结束时间为当前日期
        Beddetails beddetails = new Beddetails();
        beddetails.setId(exchangeDto.getId());
//        beddetails.setIsDeleted(1);
        beddetails.setEndDate(new Date());  // 结束时间为当前时间
        int count1 = beddetailsMapper.updateById(beddetails);
        int row = beddetailsMapper.deleteById(beddetails.getId());
        // 3.添加新床位详情信息
        Beddetails newBeddetails = new Beddetails();
        newBeddetails.setCustomerId(exchangeDto.getCustomerId());
        newBeddetails.setBedId(exchangeDto.getNewBedId());
        newBeddetails.setEndDate(exchangeDto.getEndDate());
        newBeddetails.setStartDate(new Date());
        newBeddetails.setBedDetails(exchangeDto.getBuildingNo() + "#" + bed.getBedNo());
        int count2 = beddetailsMapper.insert(newBeddetails);
        // 4.修改旧床位的状态为空闲 bed_status = 1
        Bed oldBed = new Bed();
        oldBed.setId(exchangeDto.getOldBedId());
        oldBed.setBedStatus(1);
        int count3 = bedMapper.updateById(oldBed);
        // 5.修改新床位的状态为有人 bed_status = 2
        Bed newBed = new Bed();
        newBed.setId(exchangeDto.getNewBedId());
        newBed.setBedStatus(2);
        int count4 = bedMapper.updateById(newBed);
        // 6.修改客户信息：新房间号、新床位号、新楼号
        Customer customer = new Customer();
        customer.setId(exchangeDto.getCustomerId());
        customer.setBedId(exchangeDto.getNewBedId());
        customer.setRoomNo(exchangeDto.getNewRoomNo());
        customer.setBuildingNo(exchangeDto.getBuildingNo());
        int count5 = customerMapper.updateById(customer);
        if ((count1 > 0 && count2 > 0 && count3 > 0 && count4 > 0 && count5 > 0 && row > 0)) {
            return ResultVo.ok("床位调换成功");
        }
        return ResultVo.fail("床位调换失败");
    }

    @Override
    public ResultVo delBedDetails(Integer id) {
        beddetailsMapper.delBedDetails(id);
        return ResultVo.ok("删除成功");
    }
}
