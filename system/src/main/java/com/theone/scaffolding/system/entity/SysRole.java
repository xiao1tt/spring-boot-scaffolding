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
import com.theone.scaffolding.framework.core.validator.groups.Update;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;

/**
 * <pre>
 * 系统角色
 * </pre>
 *
 * @author geekidea
 * @since 2019-10-24
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class SysRole extends BaseEntity {

    private static final long serialVersionUID = -487738234353456553L;


    @TableId(value = "id", type = IdType.AUTO)
    @NotNull(groups = Update.class, message = "角色ID不能为空")
    private Long id;


    @NotBlank(message = "角色名称不能为空")
    private String name;


    private String code;


    private Integer type;


    private Integer state;


    private String remark;


    @Null(message = "版本不用传")
    @Version
    private Integer version;


    @Null(message = "创建时间不用传")
    private Date createTime;


    @Null(message = "修改时间不用传")
    private Date updateTime;

}
