package com.cy.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Schema(name = "OutwardCountVo对象")
public class CountVo {
    @Schema(description = "总记录数")
    private Integer count;
}
