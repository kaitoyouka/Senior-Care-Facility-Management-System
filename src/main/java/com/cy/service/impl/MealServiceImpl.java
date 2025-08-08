package com.cy.service.impl;

import com.cy.domain.Meal;
import com.cy.dto.MealDto;
import com.cy.mapper.MealMapper;
import com.cy.service.IMealService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cy.utils.ResultVo;
import com.cy.vo.CountVo;
import com.cy.vo.MealVo;
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
 * @since 2025-06-25
 */
@Service
public class MealServiceImpl extends ServiceImpl<MealMapper, Meal> implements IMealService {
    @Autowired
    private MealMapper mealMapper;
    @Override
    public ResultVo listMealPage(MealDto mealDto) {
        Map<String, Object> map = new HashMap<>();
        map.put("current", mealDto.getCurrentPage());
        mealDto.setCurrentPage((mealDto.getCurrentPage() - 1) * mealDto.getPageSize());
        List<MealVo> mealVoList = mealMapper.listMealPage(mealDto);
        CountVo countVo = mealMapper.selectMealCount(mealDto);
        map.put("total", countVo.getCount());
        map.put("records", mealVoList);
        map.put("size", mealDto.getPageSize());
        map.put("pages", Math.ceil((double) countVo.getCount() / mealDto.getPageSize()));
        return ResultVo.ok(map);
    }
}
