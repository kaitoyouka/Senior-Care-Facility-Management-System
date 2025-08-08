package com.cy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.cy.domain.Bed;
import com.cy.domain.Beddetails;
import com.cy.domain.Customer;
import com.cy.dto.KhxxDto;
import com.cy.mapper.BedMapper;
import com.cy.mapper.BeddetailsMapper;
import com.cy.mapper.CustomerMapper;
import com.cy.service.ICustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cy.utils.ResultVo;
import com.cy.vo.CountVo;
import com.cy.vo.KhxxCustomerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ChadYang
 * @since 2025-06-24
 */
@Service
@Transactional
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private BedMapper bedMapper;
    @Autowired
    private BeddetailsMapper beddetailsMapper;
    @Override
    public ResultVo khxxFindCustomer(KhxxDto khxxDto) {
        List<KhxxCustomerVo> khxxCustomerVos = customerMapper.selectPageVo(((khxxDto.getCurrentPage() - 1) * khxxDto.getPageSize()),
                khxxDto.getPageSize(),
                khxxDto.getCustomerName(),
                khxxDto.getManType(),
                khxxDto.getUserId());
        CountVo countVo = customerMapper.selectCountVo(khxxDto.getCustomerName(),
                khxxDto.getManType(),
                khxxDto.getUserId());
        Map<String, Object> map = new HashMap<>();
        map.put("total", countVo.getCount());
        map.put("records", khxxCustomerVos);
        map.put("pages", Math.ceil((double) countVo.getCount() / khxxDto.getPageSize()));
        map.put("current", khxxDto.getCurrentPage());
        map.put("size", khxxDto.getPageSize());
        return ResultVo.ok(map);
    }

    @Override
    public ResultVo addCustomer(Customer customer) throws Exception {
        // 查询床位是否可用
        LambdaQueryWrapper<Bed> lqw = new LambdaQueryWrapper<>();
        Bed bed = bedMapper.selectById(customer.getBedId());
        if (bed.getBedStatus() != 1) {
            return ResultVo.fail("床位已占用");
        }
        customer.setUserId(-1); // 新客户默认无健康管家
        // 生成客户信息
        int count = customerMapper.insert(customer);
        // 生成入住详情信息
        Beddetails beddetails = new Beddetails();
        beddetails.setBedId(customer.getBedId());
        beddetails.setStartDate(customer.getCheckinDate());
        beddetails.setEndDate(customer.getExpirationDate());
        beddetails.setBedDetails(customer.getBuildingNo() + "#" + bed.getBedNo());
        beddetails.setCustomerId(customer.getId());
        beddetails.setIsDeleted(0); // 床位生效
        int count2 = beddetailsMapper.insert(beddetails);
        // 修改床位状态
        Bed bedUpdate = new Bed();
        bedUpdate.setId(customer.getBedId());
        bedUpdate.setBedStatus(2);
        int count3 = bedMapper.updateById(bedUpdate);
        if (!(count > 0 && count2 > 0 && count3 > 0)) {
            throw new Exception("入住失败！！！");
        }
        return ResultVo.ok("入住成功");
    }

    @Override
    public ResultVo editCustomer(Customer customer) throws Exception {
        int count = customerMapper.updateById(customer);
        // 如果合同到期时间发生改变，则需要更新用户当前生成的床位信息的退住时间为改变后的合同时间
        if (customer.getExpirationDate() != null) {
            LambdaUpdateWrapper<Beddetails> luw = new LambdaUpdateWrapper<>();
            luw.eq(Beddetails::getCustomerId, customer.getId())
                    .set(Beddetails::getEndDate, customer.getExpirationDate());
            Beddetails beddetails = new Beddetails();
            beddetails.setEndDate(customer.getExpirationDate());
            int count2 = beddetailsMapper.update(beddetails, luw);
            if (!(count > 0 && count2 > 0)) {
                throw new Exception("修改失败");
            }
        }
        return ResultVo.ok("修改成功");
    }

    @Override
    public ResultVo removeCustomer(Integer id, Integer bedId) throws Exception {
        int count1 = customerMapper.deleteById(id);
        // 修改床位为空闲
        LambdaUpdateWrapper<Bed> luw = new LambdaUpdateWrapper<>();
        luw.eq(Bed::getId, bedId).set(Bed::getBedStatus, 1);
        int count2 = bedMapper.update(null, luw);
        // 删除床位详情信息
        LambdaQueryWrapper<Beddetails> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Beddetails::getCustomerId, id).eq(Beddetails::getBedId, bedId);
        int count3 = beddetailsMapper.delete(lqw);
        if (!(count1 > 0 && count2 > 0 && count3 > 0)) {
            throw new Exception("删除失败");
        }
        return ResultVo.ok("删除成功");
    }
}
