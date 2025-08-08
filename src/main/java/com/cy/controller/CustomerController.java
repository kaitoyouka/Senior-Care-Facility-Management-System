package com.cy.controller;


import com.cy.domain.Customer;
import com.cy.dto.KhxxDto;
import com.cy.service.ICustomerService;
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
 * @since 2025-06-24
 */
@RestController
@RequestMapping("/customer")
@Tag(name = "客户管理")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Operation(summary = "动态查询客户信息-分页")
    @PostMapping("/listKhxxPage")
    public ResultVo listKhxxPage(@RequestBody KhxxDto khxxDto) {
        return customerService.khxxFindCustomer(khxxDto);
    }

    @Operation(summary = "入住登记")
    @PostMapping("/addCustomer")
    public ResultVo addCustomer(@RequestBody Customer customer) throws Exception {
        return customerService.addCustomer(customer);
    }

    @Operation(summary = "修改客户信息")
    @PostMapping("/editCustomer")
    public ResultVo editCustomer(@RequestBody Customer customer) throws Exception {
        return customerService.editCustomer(customer);
    }

    @Operation(summary = "删除客户信息")
    @GetMapping("/removeCustomer/{id}/{bedId}")
    public ResultVo removeCustomer(@PathVariable Integer id, @PathVariable Integer bedId) throws Exception {
        return customerService.removeCustomer(id, bedId);
    }
}

