package com.cy.mapper;

import com.cy.domain.Nurserecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cy.dto.NurseRecordDto;
import com.cy.vo.CountVo;
import com.cy.vo.NurseRecordsVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ChadYang
 * @since 2025-06-27
 */
public interface NurserecordMapper extends BaseMapper<Nurserecord> {
    List<NurseRecordsVo> selectNurseRecordsVo(NurseRecordDto nurseRecordDto);

    CountVo selectNurseRecordCount(NurseRecordDto nurseRecordDto);
}
