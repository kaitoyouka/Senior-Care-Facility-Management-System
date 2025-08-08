package com.cy.service;

import com.cy.domain.Customernurseitem;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cy.dto.CustomerNurseItemDto;
import com.cy.utils.ResultVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ChadYang
 * @since 2025-06-27
 */
public interface ICustomernurseitemService extends IService<Customernurseitem> {
    ResultVo addItemToCustomer(List<Customernurseitem> customernurseitems);

    ResultVo removeCustomerLevelAndItem(Integer levelId, Integer customerId);

    ResultVo listCustomerItem(CustomerNurseItemDto customerNurseItemDto);
}
