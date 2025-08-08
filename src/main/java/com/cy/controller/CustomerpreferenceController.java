package com.cy.controller;


import com.cy.domain.Customerpreference;
import com.cy.dto.CustomerpreferenceDto;
import com.cy.service.ICustomerpreferenceService;
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
@RequestMapping("/customerpreference")
@Tag(name = "客户喜好管理")
public class CustomerpreferenceController {
    @Autowired
    private ICustomerpreferenceService customerpreferenceService;

    @Operation(summary = "添加客户喜好")
    @PostMapping("/addCustomerpreference")
    public ResultVo addCustomerpreference(@RequestBody Customerpreference customerpreference) {
        return customerpreferenceService.save(customerpreference) ? ResultVo.ok("添加成功") : ResultVo.fail("添加失败");
    }

    @Operation(summary = "修改客户喜好")
    @PostMapping("/updateCustomerpreference")
    public ResultVo updateCustomerpreference(@RequestBody Customerpreference customerpreference) {
        return customerpreferenceService.updateById(customerpreference) ? ResultVo.ok("修改成功") : ResultVo.fail("修改失败");
    }

    @Operation(summary = "删除客户喜好")
    @GetMapping("/removeCustomerpreference/{id}")
    public ResultVo removeCustomerpreference(@PathVariable Integer id) {
        return customerpreferenceService.removeById(id) ? ResultVo.ok("删除成功") : ResultVo.fail("删除失败");
    }

    @Operation(summary = "查询客户喜好-分页，可以根据客户姓名查询")
    @PostMapping("/selectCustomerpreferenceVo")
    public ResultVo selectCustomerpreferenceVo(@RequestBody CustomerpreferenceDto customerpreferenceDto) {
        return customerpreferenceService.selectCustomerpreferenceVo(customerpreferenceDto);
    }
}

