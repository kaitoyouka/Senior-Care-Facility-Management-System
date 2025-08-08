package com.cy.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cy.domain.Customer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cy.vo.CountVo;
import com.cy.vo.KhxxCustomerVo;
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
public interface CustomerMapper extends BaseMapper<Customer> {
    List<KhxxCustomerVo> selectPageVo(@Param("currentPage") Integer currentPage,
                                      @Param("pageSize") Integer pageSize,
                                      @Param("customerName") String customerName,
                                      @Param("manType") Integer manType,
                                      @Param("userId") Integer userId);

    CountVo selectCountVo(@Param("customerName") String customerName,
                          @Param("manType") Integer manType,
                          @Param("userId") Integer userId);
}
