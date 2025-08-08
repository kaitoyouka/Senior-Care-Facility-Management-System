package com.cy.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author ChadYang
 * @since 2025-06-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(name="Room对象")
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    @Schema(description = "主键")
    private Integer id;

    /**
     * 房间楼层
     */
    @Schema(description = "房间楼层")
    private String roomFloor;

    /**
     * 房间编号
     */
    @Schema(description = "房间编号")
    private Integer roomNo;

    /**
     * 房间床位列表
     */
    @TableField(exist = false)
    @Schema(description = "房间床位列表")
    private List<Bed> bedList;
}
