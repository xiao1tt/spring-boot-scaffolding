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

package com.theone.example.order.controller;

import com.theone.example.order.entity.ExampleOrder;
import com.theone.example.order.param.ExampleOrderPageParam;
import com.theone.example.order.service.ExampleOrderService;
import  com.theone.scaffolding.framework.common.api.ApiResult;
import  com.theone.scaffolding.framework.common.controller.BaseController;
import  com.theone.scaffolding.framework.core.pagination.Paging;
import  com.theone.scaffolding.framework.core.validator.groups.Add;
import  com.theone.scaffolding.framework.core.validator.groups.Update;
import  com.theone.scaffolding.framework.log.annotation.Module;
import  com.theone.scaffolding.framework.log.annotation.OperationLog;
import  com.theone.scaffolding.framework.log.enums.OperationLogType;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 订单示例 控制器
 *
 * @author geekidea
 * @since 2020-03-27
 */
@Slf4j
@RestController
@RequestMapping("/exampleOrder")
@Module("order")
public class ExampleOrderController extends BaseController {

    @Autowired
    private ExampleOrderService exampleOrderService;

    /**
     * 添加订单示例
     */
    @PostMapping("/add")
    @OperationLog(name = "添加订单示例", type = OperationLogType.ADD)

    public ApiResult<Boolean> addExampleOrder(@Validated(Add.class) @RequestBody ExampleOrder exampleOrder) throws Exception {
        boolean flag = exampleOrderService.saveExampleOrder(exampleOrder);
        return ApiResult.result(flag);
    }

    /**
     * 修改订单示例
     */
    @PostMapping("/update")
    @OperationLog(name = "修改订单示例", type = OperationLogType.UPDATE)

    public ApiResult<Boolean> updateExampleOrder(@Validated(Update.class) @RequestBody ExampleOrder exampleOrder) throws Exception {
        boolean flag = exampleOrderService.updateExampleOrder(exampleOrder);
        return ApiResult.result(flag);
    }

    /**
     * 删除订单示例
     */
    @PostMapping("/delete/{id}")
    @OperationLog(name = "删除订单示例", type = OperationLogType.DELETE)

    public ApiResult<Boolean> deleteExampleOrder(@PathVariable("id") Long id) throws Exception {
        boolean flag = exampleOrderService.deleteExampleOrder(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取订单示例详情
     */
    @GetMapping("/info/{id}")
    @OperationLog(name = "订单示例详情", type = OperationLogType.INFO)

    public ApiResult<ExampleOrder> getExampleOrder(@PathVariable("id") Long id) throws Exception {
        ExampleOrder exampleOrder = exampleOrderService.getById(id);
        return ApiResult.ok(exampleOrder);
    }

    /**
     * 订单示例分页列表
     */
    @PostMapping("/getPageList")
    @OperationLog(name = "订单示例分页列表", type = OperationLogType.PAGE)

    public ApiResult<Paging<ExampleOrder>> getExampleOrderPageList(@Validated @RequestBody ExampleOrderPageParam exampleOrderPageParam) throws Exception {
        Paging<ExampleOrder> paging = exampleOrderService.getExampleOrderPageList(exampleOrderPageParam);
        return ApiResult.ok(paging);
    }

}

