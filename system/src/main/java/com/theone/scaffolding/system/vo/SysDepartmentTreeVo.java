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

package com.theone.scaffolding.system.vo;



import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <pre>
 * 部门TreeVo
 * </pre>
 *
 * @author geekidea
 * @since 2019-11-1
 */
@Data
@Accessors(chain = true)

public class SysDepartmentTreeVo implements Serializable {
    private static final long serialVersionUID = -2250233632748939400L;


    private Long id;


    private String name;


    private Long parentId;


    private Integer state;


    private Integer sort;


    private String remark;


    private Integer version;


    private Date createTime;


    private Date updateTime;

    private List<SysDepartmentTreeVo> children;

}
