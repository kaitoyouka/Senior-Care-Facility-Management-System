package com.cy.service;

import com.cy.domain.Customerpreference;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cy.dto.CustomerpreferenceDto;
import com.cy.utils.ResultVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ChadYang
 * @since 2025-06-25
 */
public interface ICustomerpreferenceService extends IService<Customerpreference> {
    ResultVo selectCustomerpreferenceVo(CustomerpreferenceDto customerpreferenceDto);
}
