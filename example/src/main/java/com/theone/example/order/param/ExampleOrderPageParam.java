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

package com.theone.example.order.param;

import  com.theone.scaffolding.framework.core.pagination.BasePageOrderParam;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <pre>
 * 订单示例 分页参数对象
 * </pre>
 *
 * @author geekidea
 * @date 2020-03-27
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)

public class ExampleOrderPageParam extends BasePageOrderParam {
    private static final long serialVersionUID = 6092080418269664419L;


    private String name;


    private String orderNo;

}
