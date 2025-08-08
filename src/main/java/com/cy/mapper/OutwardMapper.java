package com.cy.mapper;

import com.cy.domain.Outward;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cy.dto.OutwardDto;
import com.cy.vo.CountVo;
import com.cy.vo.OutwardVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ChadYang
 * @since 2025-06-24
 */
public interface OutwardMapper extends BaseMapper<Outward> {

    List<OutwardVo> selectOutwardVo(OutwardDto outwardDto);

    CountVo selectOutwardCount(@Param("userId") Integer userId);
}
