package com.cy.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;
import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author ChadYang
 * @since 2025-06-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(name="Beddetails对象")
public class Beddetails implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    @Schema(description = "主键")
    private Integer id;

    /**
     * 床位起始日期
     */
    @Schema(description = "床位起始日期")
    private Date startDate;

    /**
     * 床位结束日期
     */
    @Schema(description = "床位结束日期")
    private Date endDate;

    /**
     * 床位详情信息
     */
    @Schema(description = "床位详情信息")
    private String bedDetails;

    /**
     * 顾客ID
     */
    @Schema(description = "顾客ID")
    private Integer customerId;

    /**
     * 床位ID
     */
    @Schema(description = "床位ID")
    private Integer bedId;

    /**
     * 逻辑删除标记（0：显示；1：隐藏）
     */
    @TableLogic(value = "0", delval = "1")
    @Schema(description = "逻辑删除标记（0：显示；1：隐藏）")
    private Integer isDeleted;


}
