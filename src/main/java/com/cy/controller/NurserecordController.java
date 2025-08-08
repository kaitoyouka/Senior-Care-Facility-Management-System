package com.cy.controller;


import com.cy.domain.Nurserecord;
import com.cy.dto.NurseRecordDto;
import com.cy.service.INurserecordService;
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
@RequestMapping("/nurserecord")
@Tag(name = "护理记录管理")
public class NurserecordController {
    @Autowired
    private INurserecordService nurserecordService;

    @Operation(summary = "删除护理记录")
    @GetMapping("/removeCustomerRecord/{id}")
    public ResultVo removeCustomerRecord(@PathVariable Integer id) {
        return nurserecordService.removeById(id) ? ResultVo.ok("删除成功") : ResultVo.fail("删除失败");
    }

    @Operation(summary = "添加护理记录")
    @PostMapping("/addNurseRecord")
    public ResultVo addNurseRecord(@RequestBody Nurserecord nurserecord) {
        return nurserecordService.addNurseRecord(nurserecord);
    }

    @Operation(summary = "客户护理记录信息动态查询-分页")
    @PostMapping("/listNurseRecordsVo")
    public ResultVo listNurseRecordsVo(@RequestBody NurseRecordDto nurseRecordDto) {
        return nurserecordService.listNurseRecordsVo(nurseRecordDto);
    }
}

