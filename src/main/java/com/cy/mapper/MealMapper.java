package com.cy.mapper;

import com.cy.domain.Meal;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cy.dto.MealDto;
import com.cy.vo.CountVo;
import com.cy.vo.MealVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ChadYang
 * @since 2025-06-25
 */
public interface MealMapper extends BaseMapper<Meal> {
    List<MealVo> listMealPage(MealDto mealDto);

    CountVo selectMealCount(MealDto mealDto);
}
