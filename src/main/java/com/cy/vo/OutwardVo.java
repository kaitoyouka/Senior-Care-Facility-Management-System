package com.cy.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Schema(name = "OutwardVo对象")
public class OutwardVo {
    private static final long serialVersionUID = 1L;

    @Schema(description = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Schema(description = "备注")
    private String	remarks;

    @Schema(description = "逻辑删除标记（0：显示；1：隐藏）")
    private Integer	isDeleted;

    @Schema(description = "客户ID")
    private Integer	customerId;

    @Schema(description = "外出事由")
    private String	outgoingreason;

    @Schema(description = "外出时间")
    private Date outgoingtime;

    @Schema(description = "预计回院时间")
    private Date expectedreturntime;

    @Schema(description = "实际回院时间")
    private Date actualreturntime;

    @Schema(description = "陪同人")
    private String	escorted;

    @Schema(description = "与老人关系")
    private String	relation;

    @Schema(description = "陪同人电话")
    private String	escortedtel;

    @Schema(description = "审批状态 0-已提交 1-同意 2-拒绝")
    private Integer	auditstatus;

    @Schema(description = "审批人")
    private String	auditperson;

    @Schema(description = "审批时间")
    private Date audittime;

    @Schema(description = "护理人姓名")
    private String nickname;

    @Schema(description = "护理人电话号码")
    private String phoneNumber;

    @Schema(description = "护理项目编号")
    private String serialNumber;

    @Schema(description = "护理项目名称")
    private String nursingName;

    @Schema(description = "客户名称")
    private String customerName;
}
