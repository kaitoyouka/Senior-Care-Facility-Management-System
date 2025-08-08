package com.cy.domain;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@Schema(name = "Food对象")
public class Food implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 食品ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    @Schema(description = "主键")
    private Integer id;

    /**
     * 食品名称
     */
    @Schema(description = "食品名称")
    private String foodName;

    /**
     * 食品类型
     */
    @Schema(description = "食品类型")
    private String foodType;

    /**
     * 价格
     */
    @Schema(description = "价格")
    private BigDecimal price;

    /**
     * 是否清真
     */
    @Schema(description = "是否清真")
    private Integer isHalal;

    /**
     * 图片路径
     */
    @Schema(description = "图片路径")
    private String foodImg;


}
