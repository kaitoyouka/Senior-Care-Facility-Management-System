package com.cy.mapper;

import com.cy.domain.Customernurseitem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cy.dto.CustomerNurseItemDto;
import com.cy.vo.CountVo;
import com.cy.vo.CustomerNurseItemVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ChadYang
 * @since 2025-06-27
 */
public interface CustomernurseitemMapper extends BaseMapper<Customernurseitem> {
    List<CustomerNurseItemVo> listCustomerItem(CustomerNurseItemDto customerNurseItemDto);

    CountVo selectCustomerItemCount(CustomerNurseItemDto customerNurseItemDto);
}
