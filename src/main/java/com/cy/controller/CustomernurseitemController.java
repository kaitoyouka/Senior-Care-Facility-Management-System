package com.cy.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cy.domain.Customernurseitem;
import com.cy.dto.CustomerNurseItemDto;
import com.cy.service.ICustomernurseitemService;
import com.cy.utils.ResultVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ChadYang
 * @since 2025-06-27
 */
@RestController
@RequestMapping("/customernurseitem")
@Tag(name = "服务关注管理")
public class CustomernurseitemController {
    @Autowired
    private ICustomernurseitemService customernurseitemService;

    @Operation(summary = "客户续费")
    @PostMapping("/enewNurseItem")
    public ResultVo enewNurseItem(@RequestBody Customernurseitem customernurseitem) {
        customernurseitemService.updateById(customernurseitem);
        return ResultVo.ok("续费成功");
    }

    @Operation(summary = "判断客户是否已经配置了某个指定项目")
    @GetMapping("/isIncludeItemCustomer/{customerId}/{itemId}")
    public ResultVo isIncludeItemCustomer(@PathVariable Integer customerId, @PathVariable Integer itemId) {
        LambdaQueryWrapper<Customernurseitem> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Customernurseitem::getCustormerId, customerId)
            .eq(Customernurseitem::getItemId, itemId);
        int count = customernurseitemService.count(lqw);
        if (count > 0) {
            return ResultVo.ok("当前客户已存在该项目");
        }
        return ResultVo.ok("当前客户不存在该项目");
    }

    @Operation(summary = "移除客户护理项目")
    @GetMapping("/removeNurseItem/{id}")
    public ResultVo removeNurseItem(@PathVariable Integer id) {
        customernurseitemService.removeById(id);
        return ResultVo.ok("移除成功");
    }

    @Operation(summary = "为客户单个/批量添加护理项目")
    @PostMapping("/addItemToCustomer")
    public ResultVo addItemToCustomer(@RequestBody List<Customernurseitem> customernurseitems) {
        return customernurseitemService.addItemToCustomer(customernurseitems);
    }

    @Operation(summary = "移除客户护理级别且级联移除客户当前级别的护理项目")
    @GetMapping("/removeCustomerLevelAndItem/{levelId}/{customerId}")
    public ResultVo removeCustomerLevelAndItem(@PathVariable Integer levelId, @PathVariable Integer customerId) {
        return customernurseitemService.removeCustomerLevelAndItem(levelId, customerId);
    }

    @Operation(summary = "查询某个客户的护理项目列表-分页")
    @PostMapping("/listCustomerItem")
    public ResultVo listCustomerItem(@RequestBody CustomerNurseItemDto customerNurseItemDto) {
        return customernurseitemService.listCustomerItem(customerNurseItemDto);
    }
}

