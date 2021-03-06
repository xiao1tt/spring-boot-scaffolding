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

package com.theone.example.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.theone.example.order.entity.ExampleOrder;
import org.springframework.stereotype.Repository;

/**
 * 订单示例 Mapper 接口
 *
 * @author geekidea
 * @since 2020-03-27
 */
@Repository
public interface ExampleOrderMapper extends BaseMapper<ExampleOrder> {


}
