/*
 * Copyright 2019-2029 geekidea(https://github.com/geekidea)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.theone.scaffolding.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import com.theone.scaffolding.framework.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;

/**
 * <pre>
 * 系统权限
 * </pre>
 *
 * @author geekidea
 * @since 2019-10-24
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class SysPermission extends BaseEntity {

    private static final long serialVersionUID = 1L;


    @TableId(value = "id", type = IdType.AUTO)
    private Long id;


    private String name;


    private Long parentId;


    private String url;


    @NotBlank(message = "唯一编码不能为空")
    private String code;


    private String icon;


    @NotNull(message = "类型，1：菜单，2：按钮不能为空")
    private Integer type;


    @NotNull(message = "层级，1：第一级，2：第二级，N：第N级不能为空")
    private Integer level;


    private Integer state;


    private Integer sort;


    private String remark;


    @Null(message = "版本不用传")
    @Version
    private Integer version;


    @Null(message = "创建时间不用传")
    private Date createTime;


    @Null(message = "修改时间不用传")
    private Date updateTime;

}
