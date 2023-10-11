package com.xiaoxin.DormitoryAffairsBack.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import cn.hutool.core.annotation.Alias;
import com.xiaoxin.DormitoryAffairsBack.common.LDTConfig;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Getter;
import lombok.Setter;

/**
* <p>
* 
* </p>
*
* @author xiaoxin
* @since 2023-10-11
*/
@Getter
@Setter
@ApiModel(value = "User对象", description = "")
public class User implements Serializable {

private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    // 用户名
    @ApiModelProperty("用户名")
    @Alias("用户名")
    private String username;

    // 密码
    @ApiModelProperty("密码")
    @Alias("密码")
    private String password;

    // 姓名
    @ApiModelProperty("姓名")
    @Alias("姓名")
    private String name;

    // 用户唯一id标识
    @ApiModelProperty("用户唯一id标识")
    @Alias("用户唯一id标识")
    private String userid;

    // 邮箱
    @ApiModelProperty("邮箱")
    @Alias("邮箱")
    private String email;

    // 用户是否被删除，0为删除，1为存在
    @ApiModelProperty("用户是否被删除，0为删除，1为存在")
    @Alias("用户是否被删除，0为删除，1为存在")
    private Integer isDelete;

    // 用户创建时间
    @ApiModelProperty("用户创建时间")
    @Alias("用户创建时间")
    @TableField(fill = FieldFill.INSERT)
    @JsonDeserialize(using = LDTConfig.CmzLdtDeSerializer.class)
    @JsonSerialize(using = LDTConfig.CmzLdtSerializer.class)
    private LocalDateTime createTime;

    // 用户更新时间
    @ApiModelProperty("用户更新时间")
    @Alias("用户更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonDeserialize(using = LDTConfig.CmzLdtDeSerializer.class)
    @JsonSerialize(using = LDTConfig.CmzLdtSerializer.class)
    private LocalDateTime updateTime;

    // 用户头像
    @ApiModelProperty("用户头像")
    @Alias("用户头像")
    private String avatar;

    // 用户身份
    @ApiModelProperty("用户身份")
    @Alias("用户身份")
    private String role;
}