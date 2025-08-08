package com.cy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.cy.domain.Customernurseitem;
import com.cy.domain.Nurserecord;
import com.cy.dto.NurseRecordDto;
import com.cy.mapper.CustomernurseitemMapper;
import com.cy.mapper.NurserecordMapper;
import com.cy.service.INurserecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cy.utils.ResultVo;
import com.cy.vo.CountVo;
import com.cy.vo.NurseRecordsVo;
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
 * @since 2025-06-27
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class NurserecordServiceImpl extends ServiceImpl<NurserecordMapper, Nurserecord> implements INurserecordService {
    @Autowired
    private CustomernurseitemMapper customernurseitemMapper;
    @Autowired
    private NurserecordMapper nurserecordMapper;
    @Override
    public ResultVo addNurseRecord(Nurserecord nurserecord) {
        // 生成护理记录
        boolean temp = save(nurserecord);
        // 查询当前用户的护理项目余量
        LambdaQueryWrapper<Customernurseitem> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Customernurseitem::getCustormerId, nurserecord.getCustomerId())
                .eq(Customernurseitem::getItemId, nurserecord.getItemId());
        Customernurseitem customernurseitem = customernurseitemMapper.selectOne(lqw);
        // 修改用户护理项目数量
        LambdaUpdateWrapper<Customernurseitem> luw = new LambdaUpdateWrapper<>();
        luw.eq(Customernurseitem::getCustormerId, nurserecord.getCustomerId())
                .eq(Customernurseitem::getItemId, nurserecord.getItemId())
                .set(Customernurseitem::getNurseNumber, customernurseitem.getNurseNumber() - nurserecord.getNursingCount());    // 余量 - 当前护理数量
        int count = customernurseitemMapper.update(null, luw);
        if (!(count > 0 && temp)) {
            return ResultVo.fail("护理记录生成失败");
        }
        return ResultVo.fail("护理记录生成成功");
    }

    @Override
    public ResultVo listNurseRecordsVo(NurseRecordDto nurseRecordDto) {
        Map<String, Object> map = new HashMap<>();
        map.put("current", nurseRecordDto.getCurrentPage());
        nurseRecordDto.setCurrentPage((nurseRecordDto.getCurrentPage() - 1) * nurseRecordDto.getPageSize());
        List<NurseRecordsVo> nurseRecordsVoList = nurserecordMapper.selectNurseRecordsVo(nurseRecordDto);
        CountVo countVo = nurserecordMapper.selectNurseRecordCount(nurseRecordDto);
        map.put("total", countVo.getCount());
        map.put("records", nurseRecordsVoList);
        map.put("size", nurseRecordDto.getPageSize());
        map.put("pages", Math.ceil((double) countVo.getCount() / nurseRecordDto.getPageSize()));
        return ResultVo.ok(map);
    }
}
