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
 * @since 2025-06-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(name = "Nurselevelitem对象")
public class Nurselevelitem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    @Schema(description = "主键")
    private Integer id;

    /**
     * 关联护理级别
     */
    @Schema(description = "关联护理级别")
    private Integer levelId;

    /**
     * 关联护理项目
     */
    @Schema(description = "关联护理项目")
    private Integer itemId;


}
