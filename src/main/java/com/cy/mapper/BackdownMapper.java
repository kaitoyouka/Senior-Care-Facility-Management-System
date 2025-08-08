package com.cy.mapper;

import com.cy.domain.Backdown;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cy.dto.BackdownDto;
import com.cy.vo.BackdownVo;
import com.cy.vo.CountVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ChadYang
 * @since 2025-06-27
 */
public interface BackdownMapper extends BaseMapper<Backdown> {
    List<BackdownVo> listBackdownVo(BackdownDto backdownDto);

    CountVo countBackdown(BackdownDto backdownDto);
}
