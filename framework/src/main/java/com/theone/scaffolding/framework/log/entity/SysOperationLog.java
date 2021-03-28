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

package com.theone.scaffolding.framework.log.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.theone.scaffolding.framework.common.entity.BaseEntity;
import com.theone.scaffolding.framework.core.validator.groups.Update;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 系统操作日志
 *
 * @author geekidea
 * @since 2020-03-19
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class SysOperationLog extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    @NotNull(message = "id不能为空", groups = {Update.class})
    private Long id;

    private String requestId;

    private Long userId;

    private String userName;

    private String name;

    private String ip;

    private String area;

    private String operator;

    private String path;

    private String module;

    private String className;

    private String methodName;

    private String requestMethod;

    private String contentType;

    private Boolean requestBody;

    private String param;

    private String token;

    private Integer type;

    private Boolean success;

    private Integer code;

    private String message;

    private String exceptionName;

    private String exceptionMessage;

    private String browserName;

    private String browserVersion;

    private String engineName;

    private String engineVersion;

    private String osName;

    private String platformName;

    private Boolean mobile;

    private String deviceName;

    private String deviceModel;

    private String remark;

    private Date createTime;

    private Date updateTime;

}
