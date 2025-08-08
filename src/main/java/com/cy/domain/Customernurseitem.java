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
 * @since 2025-06-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(name="Customernurseitem对象")
public class Customernurseitem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    @Schema(description = "主键")
    private Integer id;

    /**
     * 护理项目编号
     */
    @Schema(description = "护理项目编号")
    private Integer itemId;

    /**
     * 客户编号
     */
    @Schema(description = "客户编号")
    private Integer custormerId;

    /**
     * 护理级别编号
     */
    @Schema(description = "护理级别编号")
    private Integer levelId;

    /**
     * 购买数量
     */
    @Schema(description = "购买数量")
    private Integer nurseNumber;

    /**
     * 逻辑删除标记（0：显示；1：隐藏）
     */
    @TableLogic(value = "0", delval = "1")
    private Integer isDeleted;

    /**
     * 服务购买日期
     */
    @Schema(description = "服务购买日期")
    private Date buyTime;

    /**
     * 服务到期日
     */
    @Schema(description = "服务到期日")
    private Date maturityTime;


}
