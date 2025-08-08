package com.cy.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Schema(name="NurseItemDto对象")
public class NurseItemDto {
    @Schema(description = "当前页码")
    private Integer currentPage;
    @Schema(description = "每页显示数量")
    private Integer pageSize;
    @Schema(description = "状态：1：启用，2：停用")
    private Integer status;
    @Schema(description = "名称")
    private String itemName;
}
