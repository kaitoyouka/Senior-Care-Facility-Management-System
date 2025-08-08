package com.cy.vo;

import com.cy.domain.Room;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Schema(name="ShowBedVo对象")
public class ShowBedVo {
    @Schema(description = "总床位")
    private Integer totalBed;
    @Schema(description = "空闲床位")
    private Integer freeBed;
    @Schema(description = "外出床位")
    private Integer outBed;
    @Schema(description = "有人床位")
    private Integer usedBed;
    @Schema(description = "房间和床位列表")
    private List<Room> roomList;
}
