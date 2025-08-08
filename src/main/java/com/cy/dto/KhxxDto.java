package com.cy.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Schema(name = "KhxxDto对象")
public class KhxxDto {
    @Schema(description = "客户姓名")
    private String customerName;
    @Schema(description = "老人类型：1：自理老人，2：护理老人，3：无管家")
    private Integer manType;
    @Schema(description = "系统健康管家Id")
    private Integer userId;
    @Schema(description = "当前页码")
    private Integer currentPage;
    @Schema(description = "每页显示数量")
    private Integer pageSize;
}
