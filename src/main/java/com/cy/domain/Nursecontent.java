package com.cy.domain;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * @since 2025-06-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(name = "Nursecontent对象")
public class Nursecontent implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    @Schema(description = "主键")
    private Integer id;

    /**
     * 编号
     */
    @Schema(description = "编号")
    private String serialNumber;

    /**
     * 名称
     */
    @Schema(description = "名称")
    private String nursingName;

    /**
     * 价格
     */
    @Schema(description = "价格")
    private String servicePrice;

    /**
     *  描述
     */
    @Schema(description = "描述")
    private String message;

    /**
     * 状态 1：启用；2：停用
     */
    @Schema(description = "状态 1：启用；2：停用")
    private Integer status;

    /**
     * 执行周期
     */
    @Schema(description = "执行周期")
    private String executionCycle;

    /**
     * 执行次数
     */
    @Schema(description = "执行次数")
    private String executionTimes;

    /**
     * 逻辑删除标记（0：显示；1：隐藏）
     */
    @TableLogic(value = "0", delval = "1")
    @Schema(description = "逻辑删除标记（0：显示；1：隐藏）")
    private Integer isDeleted;


}
