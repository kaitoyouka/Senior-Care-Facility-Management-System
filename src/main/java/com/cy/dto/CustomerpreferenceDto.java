package com.cy.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Schema(name = "CustomerpreferenceDto对象")
public class CustomerpreferenceDto {
    @Schema(description = "当前页码")
    private Integer currentPage;
    @Schema(description = "每页显示数量")
    private Integer pageSize;
    @Schema(description = "客户名称")
    private String customerName;
    @Schema(description = "喜好编号")
    private Integer customerPreferenceId;
}
