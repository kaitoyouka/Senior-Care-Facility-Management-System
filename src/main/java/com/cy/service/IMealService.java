package com.cy.service;

import com.cy.domain.Meal;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cy.dto.MealDto;
import com.cy.utils.ResultVo;
import com.cy.vo.MealVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Spr1ng
 * @since 2025-07-14
 */
public interface IMealService extends IService<Meal> {
    ResultVo listMealPage(MealDto mealDto);
}
