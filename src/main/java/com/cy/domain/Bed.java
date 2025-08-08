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
 * @since 2025-06-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(name="Bed对象", description="")
public class Bed implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    @Schema(description = "主键")
    private Integer id;

    /**
     * 房间编号
     */
    @Schema(description = "房间编号")
    private Integer roomNo;

    /**
     * 房间状态 1：空闲  2：有人  3：外出
     */
    @Schema(description = "房间状态 1：空闲  2：有人  3：外出")
    private Integer bedStatus;

    /**
     * 备注
     */
    @Schema(description = "备注")
    private String remarks;

    /**
     * 床位编号
     */
    @Schema(description = "床位编号")
    private String bedNo;


}
