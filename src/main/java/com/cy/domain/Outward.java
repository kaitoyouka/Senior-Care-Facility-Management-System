package com.cy.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2025-06-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(name = "Outward对象", description = "")
public class Outward implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    @Schema(description = "主键")
    private Integer id;

    /**
     * 备注
     */
    @Schema(description = "备注")
    private String remarks;

    /**
     * 逻辑删除标记（0：显示；1：隐藏）
     */
    @TableLogic(value = "0", delval = "1")
    @Schema(description = "逻辑删除标记（0：显示；1：隐藏）")
    private Integer isDeleted;

    /**
     * 客户ID
     */
    @Schema(description = "客户ID")
    private Integer customerId;

    /**
     * 外出事由
     */
    @Schema(description = "外出事由")
    private String outgoingreason;

    /**
     * 外出时间
     */
    @Schema(description = "预计回院时间")
    private LocalDate outgoingtime;

    /**
     * 预计回院时间
     */
    @Schema(description = "预计回院时间")
    private LocalDate expectedreturntime;

    /**
     * 实际回院时间
     */
    @Schema(description = "实际回院时间")
    private LocalDate actualreturntime;

    /**
     * 陪同人
     */
    @Schema(description = "陪同人")
    private String escorted;

    /**
     * 与老人关系
     */
    @Schema(description = "与老人关系")
    private String relation;

    /**
     * 陪同人电话
     */
    @Schema(description = "陪同人电话")
    private String escortedtel;

    /**
     * 审批状态  0-已提交 1-同意  2-拒绝
     */
    @Schema(description = "审批状态  0-已提交 1-同意  2-拒绝")
    private Integer auditstatus;

    /**
     * 审批人
     */
    @Schema(description = "审批人")
    private String auditperson;

    /**
     * 审批时间
     */
    @Schema(description = "审批时间")
    private LocalDate audittime;


}
