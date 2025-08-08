package com.cy.domain;

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
 * @since 2025-06-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(name = "Rolemenu对象", description = "")
public class Rolemenu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    @Schema(description = "主键")
    private Integer id;

    /**
     * 角色编号
     */
    @Schema(description = "角色编号")
    private Integer roleId;

    /**
     * 菜单编号
     */
    @Schema(description = "菜单编号")
    private Integer menu;


}
