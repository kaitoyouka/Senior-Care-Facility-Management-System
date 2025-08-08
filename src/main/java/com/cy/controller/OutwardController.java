package com.cy.controller;


import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.cy.domain.Outward;
import com.cy.dto.OutwardDto;
import com.cy.service.IOutwardService;
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
@RequestMapping("/outward")
@Tag(name = "外出管理")
public class OutwardController {
    @Autowired
    private IOutwardService outwardService;
    @Operation(summary = "根据用户ID查询对应的客户信息")
    @PostMapping("/selectOutwardVo")
    public ResultVo selectOutwardVo(@RequestBody OutwardDto outwardDto) {
        return outwardService.selectOutwardVo(outwardDto);
    }

    @Operation(summary = "外出审批")
    @PostMapping("/examineOutward")
    public ResultVo examineOutward(@RequestBody Outward outward) {
        return outwardService.examineOutward(outward);
    }

    @Operation(summary = "添加外出审批")
    @PostMapping("/addOutward")
    public ResultVo addOutward(@RequestBody Outward outward) {
        return outwardService.save(outward) ? ResultVo.ok("添加成功") : ResultVo.fail("添加失败");
    }

    @Operation(summary = "撤回外出审批")
    @GetMapping("/delOutward/{id}")
    public ResultVo delOutward(@PathVariable Integer id) {
        return outwardService.removeById(id) ? ResultVo.ok("撤回成功") : ResultVo.fail("撤回失败");
    }

    @Operation(summary = "登记回院时间")
    @PostMapping("/updateBackTime")
    public ResultVo updateBackTime(@RequestBody Outward outward) {
        LambdaUpdateWrapper<Outward> luw = new LambdaUpdateWrapper<>();
        luw.eq(Outward::getId, outward.getId()).set(Outward::getActualreturntime, outward.getActualreturntime());
        return outwardService.update(outward, luw) ? ResultVo.ok("登记成功") : ResultVo.fail("登记失败");
    }
}

