package com.cy.service;

import com.cy.domain.Nurserecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cy.dto.NurseRecordDto;
import com.cy.utils.ResultVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ChadYang
 * @since 2025-06-27
 */
public interface INurserecordService extends IService<Nurserecord> {
    ResultVo addNurseRecord(Nurserecord nurserecord);

    ResultVo listNurseRecordsVo(NurseRecordDto nurseRecordDto);
}
