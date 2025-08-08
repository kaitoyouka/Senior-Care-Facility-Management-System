package com.cy.controller;


import com.cy.domain.Beddetails;
import com.cy.dto.BeddetailsDto;
import com.cy.dto.ExchangeDto;
import com.cy.service.IBeddetailsService;
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
@RequestMapping("/beddetails")
@Tag(name = "床位信息管理")
public class BeddetailsController {
    @Autowired
    private IBeddetailsService beddetailsService;

    @Operation(summary = "查询所有床位详情信息-分页")
    @PostMapping("/listBedDetails")
    public ResultVo listBedDetails(@RequestBody BeddetailsDto beddetailsDto) {
        return beddetailsService.selectBedDetailsVo(beddetailsDto);
    }

    @Operation(summary = "更新床位使用详情-只能修改床位使用结束时间")
    @PostMapping("/updateBedDetails")
    public ResultVo updateBedDetails(@RequestBody Beddetails beddetails) {
        return beddetailsService.updateById(beddetails) ? ResultVo.ok("修改成功") : ResultVo.fail("修改失败");
    }

    @Operation(summary = "删除床位使用详情")
    @GetMapping("/delBedDetails/{id}")
    public ResultVo delBedDetails(@PathVariable Integer id) {
        return beddetailsService.delBedDetails(id);
    }

    @Operation(summary = "床位调换")
    @PostMapping("/exchangeBed")
    public ResultVo exchangeBed(@RequestBody ExchangeDto exchangeDto) {
        return beddetailsService.exchangeBed(exchangeDto);
    }
}

