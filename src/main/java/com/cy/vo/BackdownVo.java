package com.cy.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "退住信息")
public class BackdownVo {
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
    private Integer isDeleted;

    /**
     * 客户ID
     */
    @Schema(description = "客户ID")
    private Integer customerId;

    /**
     * 退住时间
     */
    @Schema(description = "退住时间")
    private Date retreattime;

    /**
     * 退住类型 0-正常退住  1-死亡退住 2-保留床位
     */
    @Schema(description = "退住类型 0-正常退住  1-死亡退住 2-保留床位")
    private Integer retreattype;

    /**
     * 退住原因
     */
    @Schema(description = "退住原因")
    private String retreatreason;

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
    private Date audittime;

    @Schema(description = "床位详情")
    private String bedDetails;

    @Schema(description = "入住时间")
    private Date checkinDate;

    @Schema(description = "床位")
    private String bedId;

    @Schema(description = "客户名称")
    private String customerName;
}
