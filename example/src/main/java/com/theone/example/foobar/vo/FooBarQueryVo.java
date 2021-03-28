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

package com.theone.example.foobar.vo;



import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <pre>
 * FooBar 查询结果对象
 * </pre>
 *
 * @author geekidea
 * @date 2020-03-23
 */
@Data
@Accessors(chain = true)

public class FooBarQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long id;


    private String name;


    private String foo;


    private String bar;


    private String remark;


    private Integer state;


    private Integer version;


    private Date createTime;


    private Date updateTime;

}