package com.cy.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.cy.domain.Outward;
import com.cy.dto.OutwardDto;
import com.cy.mapper.OutwardMapper;
import com.cy.service.IOutwardService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cy.utils.ResultVo;
import com.cy.vo.CountVo;
import com.cy.vo.OutwardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class OutwardServiceImpl extends ServiceImpl<OutwardMapper, Outward> implements IOutwardService {
    @Autowired
    private OutwardMapper outwardMapper;
    @Override
    public ResultVo selectOutwardVo(OutwardDto outwardDto) {
        Map<String, Object> map = new HashMap<>();
        map.put("current", outwardDto.getCurrentPage());
        outwardDto.setCurrentPage((outwardDto.getCurrentPage() - 1) * outwardDto.getPageSize());
        List<OutwardVo> outwardVos = outwardMapper.selectOutwardVo(outwardDto);
        CountVo totalMap = outwardMapper.selectOutwardCount(outwardDto.getUserId());
        int total = totalMap.getCount();
        map.put("total", total);
        map.put("records", outwardVos);
        map.put("size", outwardDto.getPageSize());
        map.put("pages", Math.ceil((double) total / outwardDto.getPageSize()));
        return ResultVo.ok(map);
    }

    @Override
    public ResultVo examineOutward(Outward outward) {
        LambdaUpdateWrapper<Outward> luw = new LambdaUpdateWrapper<>();
        luw.eq(Outward::getId, outward.getId()).set(Outward::getAuditstatus, outward.getAuditstatus());
        outwardMapper.update(outward, luw);
        return ResultVo.ok("审批成功");
    }
}
