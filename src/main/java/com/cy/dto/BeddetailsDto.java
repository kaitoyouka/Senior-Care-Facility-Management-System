package com.cy.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Schema(name="BeddetailsDto对象")
public class BeddetailsDto {
    @Schema(description = "当前页码")
    private Integer currentPage;
    @Schema(description = "每页显示数量")
    private Integer pageSize;
    @Schema(description = "客户姓名")
    private String customerName;
    @Schema(description = "开始时间")
    private Date startDate;
    @Schema(description = "结束时间")
    private Date endDate;
    @Schema(description = "查询类型：0：生效床位信息，1：失效床位信息（历史记录）")
    private Integer isDeleted;
}
