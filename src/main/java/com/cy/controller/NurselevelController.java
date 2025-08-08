package com.cy.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cy.domain.Nurselevel;
import com.cy.domain.Nurselevelitem;
import com.cy.service.INursecontentService;
import com.cy.service.INurselevelService;
import com.cy.service.INurselevelitemService;
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
@RequestMapping("/nurselevel")
@Tag(name = "护理等级管理")
public class NurselevelController {
    @Autowired
    private INurselevelService nurselevelService;
    @Autowired
    private INurselevelitemService nurselevelitemService;
    @Autowired
    private INursecontentService nursecontentService;

    @Operation(summary = "添加护理级别")
    @PostMapping("/addNurselevel")
    public ResultVo addNurselevel(@RequestBody Nurselevel nurselevel) {
        return nurselevelService.save(nurselevel) ? ResultVo.ok("添加护理级别成功") : ResultVo.fail("添加护理级别失败");
    }

    @Operation(summary = "更新护理级别")
    @PostMapping("/updateNurselevel")
    public ResultVo updateNurselevel(@RequestBody Nurselevel nurselevel) {
        return nurselevelService.updateById(nurselevel) ? ResultVo.ok("更新护理级别成功") : ResultVo.fail("更新护理级别失败");
    }

    @Operation(summary = "删除护理级别")
    @GetMapping("removeNurselevel/{id}")
    public ResultVo removeNurselevel(@PathVariable Integer id) {
        return nurselevelService.removeById(id) ? ResultVo.ok("删除护理级别成功") : ResultVo.fail("删除护理级别失败");
    }

    @Operation(summary = "查询护理级别列表")
    @PostMapping("/listNurselevel")
    public ResultVo listNurselevel(@RequestBody Nurselevel nurselevel) {
        LambdaQueryWrapper<Nurselevel> lqw = new LambdaQueryWrapper<>();
        if (nurselevel.getLevelStatus() != null) {
            lqw.eq(Nurselevel::getLevelStatus, nurselevel.getLevelStatus());
        }
        return ResultVo.ok(nurselevelService.list(lqw));
    }

    @Operation(summary = "删除护理级别中的护理项目")
    @GetMapping("/removeNurseLevelItem/{levelId}/{itemId}")
    public ResultVo removeNurseLevelItem(@PathVariable Integer levelId, @PathVariable Integer itemId) {
        LambdaQueryWrapper<Nurselevelitem> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Nurselevelitem::getLevelId, levelId)
            .eq(Nurselevelitem::getItemId, itemId);
        nurselevelitemService.remove(lqw);
        return ResultVo.ok("删除成功");
    }

    @Operation(summary = "根据护理级别查询护理项目")
    @GetMapping("/listNurseItemByLevel/{levelId}")
    public ResultVo listNurseItemByLevel(@PathVariable Integer levelId) {
        return nursecontentService.listNurseItemByLevel(levelId);
    }

    @Operation(summary = "护理项目的配置")
    @PostMapping("/addItemToLevel")
    public ResultVo addItemToLevel(@RequestBody Nurselevelitem nurselevelitem) {
        // 判断当前级别是否存在相同的护理项目
        LambdaQueryWrapper<Nurselevelitem> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Nurselevelitem::getLevelId, nurselevelitem.getLevelId())
                .eq(Nurselevelitem::getItemId, nurselevelitem.getItemId());
        int count = nurselevelitemService.count(lqw);
        if (count > 0) {
            return ResultVo.fail("当前级别已存在相同的护理项目");
        }
        nurselevelitemService.save(nurselevelitem);
        return ResultVo.ok("添加成功");
    }
}

