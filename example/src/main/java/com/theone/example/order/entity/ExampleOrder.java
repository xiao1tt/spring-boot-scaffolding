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

package com.theone.example.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import  com.theone.scaffolding.framework.common.entity.BaseEntity;
import  com.theone.scaffolding.framework.core.validator.groups.Update;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 订单示例
 *
 * @author geekidea
 * @since 2020-03-27
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)

public class ExampleOrder extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id不能为空", groups = {Update.class})

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @NotBlank(message = "订单名称不能为空")

    private String name;


    private String orderNo;


    private String remark;


    private Integer state;


    @Version
    private Integer version;


    private Date createTime;


    private Date updateTime;

}
