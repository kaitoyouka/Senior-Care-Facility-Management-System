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
 * @since 2025-06-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(name = "Meal对象")
public class Meal implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 饮食ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    @Schema(description = "主键")
    private Integer id;

    /**
     * 星期几
     */
    @Schema(description = "星期几")
    private String weekDay;

    /**
     * 食品ID
     */
    @Schema(description = "食品ID")
    private Integer foodId;

    /**
     * 食品类型（1.早餐、2.午餐、3.晚餐）
     */
    @Schema(description = "食品类型（1.早餐、2.午餐、3.晚餐）")
    private Integer mealType;

    /**
     * 口味（多糖、多盐、少糖、少盐）
     */
    @Schema(description = "口味（多糖、多盐、少糖、少盐）")
    private String taste;

    @TableLogic(value = "0", delval = "1")
    @Schema(description = "逻辑删除标记（0：显示；1：隐藏）")
    private Integer isDeleted;


}
