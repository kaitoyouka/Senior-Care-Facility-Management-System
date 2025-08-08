package com.cy.mapper;

import com.cy.domain.Beddetails;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cy.dto.BeddetailsDto;
import com.cy.vo.BedDetailsVo;
import com.cy.vo.CountVo;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ChadYang
 * @since 2025-06-25
 */
public interface BeddetailsMapper extends BaseMapper<Beddetails> {
    List<BedDetailsVo> selectBedDetailsVo(BeddetailsDto beddetailsDto);

    CountVo selectCountVo(BeddetailsDto beddetailsDto);

    @Delete("delete from beddetails where id=#{id} and is_deleted = 1")
    Integer delBedDetails(Integer id);
}
