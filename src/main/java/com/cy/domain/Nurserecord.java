package com.cy.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author ChadYang
 * @since 2025-06-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(name = "Nurserecord对象")
public class Nurserecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    @Schema(description = "主键")
    private Integer id;

    /**
     * 逻辑删除标记（0：显示；1：隐藏）
     */
    @TableLogic(value = "0", delval = "1")
    private Integer isDeleted;

    /**
     * 客户ID
     */
    @Schema(description = "客户ID")
    private Integer customerId;

    /**
     * 护理项目ID
     */
    @Schema(description = "护理项目ID")
    private Integer itemId;

    /**
     * 护理时间
     */
    @Schema(description = "护理时间")
    private Timestamp nursingTime;

    /**
     * 护理内容
     */
    @Schema(description = "护理内容")
    private String nursingContent;

    /**
     * 护理数量
     */
    @Schema(description = "护理数量")
    private Integer nursingCount;

    /**
     * 护理人员ID
     */
    @Schema(description = "护理人员ID")
    private Integer userId;


}
