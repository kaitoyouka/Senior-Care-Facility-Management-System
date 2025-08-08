package com.cy.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Schema(name = "UserDto-用户查询条件", description = "")
public class UserDto {
    @Schema(description = "系统角色编号（1-管理员 2-健康管家）")
    private Integer roleId;
    @Schema(description = "当前页码")
    private Integer currentPage;
    @Schema(description = "每页显示数量")
    private Integer pageSize;
    @Schema(description = "真实姓名")
    private String nickname;
}
