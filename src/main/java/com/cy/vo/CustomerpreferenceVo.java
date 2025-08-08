package com.cy.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Schema(name = "CustomerpreferenceVo对象")
public class CustomerpreferenceVo {
    private static final long serialVersionUID = 1L;

    /**
     * 喜好ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    @Schema(description = "主键")
    private Integer id;

    /**
     * 顾客ID
     */
    @Schema(description = "顾客ID")
    private Integer customerId;

    /**
     * 饮食喜好
     */
    @Schema(description = "饮食喜好")
    private String preferences;

    /**
     * 注意事项
     */
    @Schema(description = "注意事项")
    private String attention;

    /**
     * 备注
     */
    @Schema(description = "备注")
    private String remark;

    @TableLogic(value = "0", delval = "1")
    @Schema(description = "逻辑删除标记（0：显示；1：隐藏）")
    private Integer isDeleted;

    @Schema(description = "客户名称")
    private String customerName;
    @Schema(description = "客户年龄")
    private Integer customerAge;
    @Schema(description = "客户性别")
    private String customerSex;
}
