package com.cy.service.impl;

import com.cy.domain.Food;
import com.cy.mapper.FoodMapper;
import com.cy.service.IFoodService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ChadYang
 * @since 2025-06-25
 */
@Service
public class FoodServiceImpl extends ServiceImpl<FoodMapper, Food> implements IFoodService {

}
