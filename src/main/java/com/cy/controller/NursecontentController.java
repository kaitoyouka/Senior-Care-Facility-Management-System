package com.cy.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cy.domain.Nursecontent;
import com.cy.dto.NurseItemDto;
import com.cy.service.INursecontentService;
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
@RequestMapping("/nursecontent")
@Tag(name = "护理内容管理")
public class NursecontentController {
    @Autowired
    private INursecontentService nursecontentService;

    @Operation(summary = "添加护理项目")
    @PostMapping("/addNurseItem")
    public ResultVo addNurseItem(@RequestBody Nursecontent nursecontent) {
        nursecontentService.save(nursecontent);
        return ResultVo.ok("护理项目添加成功");
    }

    @Operation(summary = "查询护理项目-分页")
    @PostMapping("/findNurseItemPage")
    public ResultVo findNurseItemPage(@RequestBody NurseItemDto nurseItemDto) {
        IPage<Nursecontent> page = new Page<>(nurseItemDto.getCurrentPage(), nurseItemDto.getPageSize());
        LambdaQueryWrapper<Nursecontent> lqw = new LambdaQueryWrapper<>();
        if (nurseItemDto.getItemName() != null && !nurseItemDto.getItemName().equals("")) {
            lqw.like(Nursecontent::getNursingName, nurseItemDto.getItemName());
        }
        lqw.eq(Nursecontent::getStatus, nurseItemDto.getStatus());
        nursecontentService.page(page, lqw);
        return ResultVo.ok(page);
    }

    @Operation(summary = "更新护理项目")
    @PostMapping("/updateNurseItem")
    public ResultVo updateNurseItem(@RequestBody Nursecontent nursecontent) {
        return nursecontentService.updateNurseItem(nursecontent);
    }

    @Operation(summary = "删除护理项目")
    @GetMapping("/delNurseItem/{id}")
    public ResultVo delNurseItem(@PathVariable Integer id) {
        return nursecontentService.delNurseItem(id);
    }
}

