package com.cy.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Schema(name = "BedDetailsVo对象")
public class BedDetailsVo {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    @Schema(description = "主键")
    private Integer id;

    /**
     * 床位起始日期
     */
    @Schema(description = "床位起始日期")
    private Date startDate;

    /**
     * 床位结束日期
     */
    @Schema(description = "床位结束日期")
    private Date endDate;

    /**
     * 床位详情信息
     */
    @Schema(description = "床位详情信息")
    private String bedDetails;

    /**
     * 顾客ID
     */
    @Schema(description = "顾客ID")
    private Integer customerId;

    /**
     * 床位ID
     */
    @Schema(description = "床位ID")
    private Integer bedId;

    /**
     * 逻辑删除标记（0：显示；1：隐藏）
     */
    @TableLogic(value = "0", delval = "1")
    @Schema(description = "逻辑删除标记（0：显示；1：隐藏）")
    private Integer isDeleted;

    @Schema(description = "客户姓名")
    private String customerName;

    @Schema(description = "客户性别：0：男，1：女")
    private String customerSex;

    @Schema(description = "房间号")
    private String roomNo;
}
