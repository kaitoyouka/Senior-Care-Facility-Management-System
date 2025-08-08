package com.cy.mapper;

import com.cy.domain.Bed;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cy.vo.ShowBedVo;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ChadYang
 * @since 2025-06-24
 */
public interface BedMapper extends BaseMapper<Bed> {
    ShowBedVo selectBedCount();
}
