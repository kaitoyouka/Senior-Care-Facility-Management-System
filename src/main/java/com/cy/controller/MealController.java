package com.cy.controller;


import com.cy.domain.Meal;
import com.cy.dto.MealDto;
import com.cy.service.IMealService;
import com.cy.utils.ResultVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ChadYang
 * @since 2025-06-25
 */
@RestController
@RequestMapping("/meal")
@Tag(name = "膳食日历管理")
public class MealController {
    @Autowired
    private IMealService mealService;

    @Operation(summary = "添加膳食")
    @PostMapping("/addMeal")
    public ResultVo addMeal(@RequestBody Meal meal) {
        mealService.save(meal);
        return ResultVo.ok("膳食添加成功");
    }

    @Operation(summary = "更新膳食")
    @PostMapping("/updateMeal")
    public ResultVo updateMeal(@RequestBody Meal meal) {
        mealService.updateById(meal);
        return ResultVo.ok("膳食更新成功");
    }

    @Operation(summary = "删除膳食")
    @GetMapping("/removeMeal/{id}")
    public ResultVo removeMeal(@PathVariable Integer id) {
        mealService.removeById(id);
        return ResultVo.ok("膳食删除成功");
    }

    @Operation(summary = "膳食查询-分页-可以根据星期查询/根据膳食类型（早餐/午餐/晚餐）")
    @PostMapping("/listMealPage")
    public ResultVo listMealPage(@RequestBody MealDto mealDto) {
        return mealService.listMealPage(mealDto);
    }
}

