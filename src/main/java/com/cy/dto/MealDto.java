package com.cy.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Schema(name = "MealDto对象")
public class MealDto {
    @Schema(description = "当前页码")
    private Integer currentPage;
    @Schema(description = "每页显示数量")
    private Integer pageSize;
    @Schema(description = "星期几")
    private String weekDay;
    @Schema(description = "早餐/午餐/晚餐")
    private Integer mealType;
    @Schema(description = "食谱编号")
    private Integer mealId;
}
