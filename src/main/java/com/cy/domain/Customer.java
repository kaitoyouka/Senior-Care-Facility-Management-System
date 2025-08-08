package com.cy.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;
import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author ChadYang
 * @since 2025-06-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(name = "Customer对象")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    @Schema(description = "主键")
    private Integer id;

    /**
     * 逻辑删除标记（0：显示；1：隐藏）
     */
    @TableLogic(value = "0", delval = "1")
    @Schema(description = "逻辑删除标记（0：显示；1：隐藏）")
    private Integer isDeleted;

    /**
     * 客户姓名
     */
    @Schema(description = "客户姓名")
    private String customerName;

    /**
     * 年龄
     */
    @Schema(description = "年龄")
    private Integer customerAge;

    /**
     * 性别  0：男  1：女
     */
    @Schema(description = "性别  0：男  1：女")
    private Integer customerSex;

    /**
     * 身份证号
     */
    @Schema(description = "身份证号")
    private String idcard;

    /**
     * 房间号
     */
    @Schema(description = "房间号")
    private String roomNo;

    /**
     * 所属楼房
     */
    @Schema(description = "所属楼房")
    private String buildingNo;

    /**
     * 入住时间
     */
    @Schema(description = "入住时间")
    private Date checkinDate;

    /**
     * 合同到期时间
     */
    @Schema(description = "合同到期时间")
    private Date expirationDate;

    /**
     * 联系电话
     */
    @Schema(description = "联系电话")
    private String contactTel;

    /**
     * 床号
     */
    @Schema(description = "床号")
    private Integer bedId;

    /**
     * 身心状况
     */
    @Schema(description = "身心状况")
    private String psychosomaticState;

    /**
     * 注意事项
     */
    @Schema(description = "注意事项")
    private String attention;

    /**
     * 出生日期
     */
    @Schema(description = "出生日期")
    private Date birthday;

    /**
     * 身高
     */
    @Schema(description = "身高")
    private String height;

    /**
     * 体重
     */
    @Schema(description = "体重")
    private String weight;

    /**
     * 血型
     */
    @Schema(description = "血型")
    private String bloodType;

    /**
     * 头像路径
     */
    @Schema(description = "头像路径")
    private String filepath;

    /**
     * 关联系统健康管家(护工)  无管家设置  -1
     */
    @Schema(description = "关联系统健康管家(护工)  无管家设置  -1")
    private Integer userId;

    /**
     * 护理等级
     */
    @Schema(description = "护理等级")
    private Integer levelId;

    /**
     * 家属
     */
    @Schema(description = "家属")
    private String familyMember;


}
