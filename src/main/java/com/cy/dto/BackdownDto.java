package com.cy.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Schema(name="BackdownDto对象")
public class BackdownDto {
    @Schema(description = "当前页码")
    private Integer currentPage;
    @Schema(description = "每页显示数量")
    private Integer pageSize;
    @Schema(description = "用户id")
    private Integer userId;
}
