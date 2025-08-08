package com.cy.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;
import java.util.Date;
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
 * @since 2025-06-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(name = "User对象", description = "")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    @Schema(description = "主键")
    private Integer id;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    private Date createTime;

    /**
     * 创建者
     */
    @Schema(description = "创建者")
    private Integer createBy;

    /**
     * 更新时间
     */
    @Schema(description = "更新时间")
    private Date updateTime;

    /**
     * 更新者
     */
    @Schema(description = "更新者")
    private Integer updateBy;

    /**
     * 逻辑删除标记（0：显示；1：隐藏）
     */
    @TableLogic(value = "0", delval = "1")
    @Schema(description = "逻辑删除标记（0：显示；1：隐藏）")
    private Integer isDeleted;

    /**
     * 真实姓名
     */
    @Schema(description = "真实姓名")
    private String nickname;

    /**
     * 系统账号
     */
    @Schema(description = "系统账号")
    private String username;

    /**
     * 密码
     */
    @Schema(description = "密码")
    private String password;

    /**
     * 性别（0：女  1：男）
     */
    @Schema(description = "性别（0：女  1：男）")
    private Integer sex;

    /**
     * 邮箱
     */
    @Schema(description = "邮箱")
    private String email;

    /**
     * 电话号码
     */
    @Schema(description = "电话号码")
    private String phoneNumber;

    /**
     * 系统角色编号（1-管理员 2-健康管家）
     */
    @Schema(description = "系统角色编号（1-管理员 2-健康管家）")
    private Integer roleId;

    /**
     * 当前用户菜单列表
     */
    @TableField(exist = false)
    @Schema(description = "当前用户菜单列表")
    private List<Menu> menuList;

}
