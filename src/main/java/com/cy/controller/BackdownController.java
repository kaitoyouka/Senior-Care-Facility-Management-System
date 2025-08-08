package com.cy.controller;


import com.cy.domain.Backdown;
import com.cy.domain.Bed;
import com.cy.domain.Customer;
import com.cy.dto.BackdownDto;
import com.cy.service.IBackdownService;
import com.cy.service.IBedService;
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
 * @since 2025-06-27
 */
@RestController
@RequestMapping("/backdown")
@Tag(name = "退住管理")
public class BackdownController {
    @Autowired
    private IBackdownService backdownService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IBedService bedService;

    @Operation(summary = "添加退住审批")
    @PostMapping("/addBackdown")
    public ResultVo addBackdown(@RequestBody Backdown backdown) {
        backdownService.save(backdown);
        return ResultVo.ok("退住审批添加成功");
    }

    @Operation(summary = "审批退住申请")
    @PostMapping("/examineBackdown")
    public ResultVo examineBackdown(@RequestBody Backdown backdown) {
        Backdown bd = backdownService.getById(backdown.getId());
        // 审批通过
        if (backdown.getAuditstatus() == 1) {
            // 修改床位记录，将对应床位状态改为空闲
            Customer cs = customerService.getById(bd.getCustomerId());
            Bed bed = new Bed();
            bed.setId(cs.getBedId());
            bed.setBedStatus(1);
            bedService.updateById(bed);
        }
        return backdownService.examineBackdown(backdown);
    }

    @Operation(summary = "动态查询退住信息列表-分页")
    @PostMapping("/listBackdownVo")
    public ResultVo listBackdownVo(@RequestBody BackdownDto backdownDto) {
        return backdownService.listBackdownVo(backdownDto);
    }

    @Operation(summary = "撤回退住申请")
    @GetMapping("/delBackdown")
    public ResultVo delBackdown(Integer id) {
        return backdownService.removeById(id) ? ResultVo.ok("退住申请撤回成功") : ResultVo.fail("退住申请撤回失败");
    }
}

