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
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import com.theone.scaffolding.framework.common.entity.BaseEntity;
import com.theone.scaffolding.framework.core.validator.groups.Add;
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
 * 系统用户
 * </pre>
 *
 * @author geekidea
 * @since 2019-10-24
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)

public class SysUser extends BaseEntity {

    private static final long serialVersionUID = 1L;


    @NotNull(message = "ID不能为空", groups = {Update.class})
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;


    @NotNull(message = "用户名不能为空", groups = {Add.class})
    private String username;


    private String nickname;


    private String password;


    private String salt;


    @NotBlank(message = "手机号码不能为空")
    private String phone;


    private Integer gender;


    private String head;


    private String remark;


    private Integer state;


    @NotNull(message = "部门id不能为空")
    private Long departmentId;


    @NotNull(message = "角色id不能为空")
    private Long roleId;


    @Null(message = "逻辑删除不用传")
    @TableLogic
    private Integer deleted;


    @Null(message = "版本不用传")
    @Version
    private Integer version;


    @Null(message = "创建时间不用传")
    private Date createTime;


    @Null(message = "修改时间不用传")
    private Date updateTime;

}
