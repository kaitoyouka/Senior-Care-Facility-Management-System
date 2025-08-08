package com.cy.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.cy.domain.Backdown;
import com.cy.dto.BackdownDto;
import com.cy.mapper.BackdownMapper;
import com.cy.service.IBackdownService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cy.utils.ResultVo;
import com.cy.vo.BackdownVo;
import com.cy.vo.CountVo;
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
 * @author Spr1ng
 * @since 2025-06-27
 */
@Service
@Transactional
public class BackdownServiceImpl extends ServiceImpl<BackdownMapper, Backdown> implements IBackdownService {
    @Autowired
    private BackdownMapper backdownMapper;
    @Override
    public ResultVo examineBackdown(Backdown backdown) {
        LambdaUpdateWrapper<Backdown> luw = new LambdaUpdateWrapper<>();
        luw.eq(Backdown::getId, backdown.getId())
                .set(Backdown::getAuditstatus, backdown.getAuditstatus())
                .set(Backdown::getAudittime, backdown.getAudittime())
                .set(Backdown::getAuditperson, backdown.getAuditperson());
        backdownMapper.update(backdown, luw);
        return ResultVo.ok("审批成功");
    }

    @Override
    public ResultVo listBackdownVo(BackdownDto backdownDto) {
        Map<String, Object> map = new HashMap<>();
        map.put("current", backdownDto.getCurrentPage());
        backdownDto.setCurrentPage((backdownDto.getCurrentPage() - 1) * backdownDto.getPageSize());
        List<BackdownVo> backdownVoList = backdownMapper.listBackdownVo(backdownDto);
        CountVo countVo = backdownMapper.countBackdown(backdownDto);
        map.put("records", backdownVoList);
        map.put("total", countVo.getCount());
        map.put("size", backdownDto.getPageSize());
        map.put("pages", Math.ceil((double) countVo.getCount() / backdownDto.getPageSize()));
        return ResultVo.ok(map);
    }
}
