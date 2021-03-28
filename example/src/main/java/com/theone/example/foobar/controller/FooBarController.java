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

package com.theone.example.foobar.controller;

import com.theone.example.foobar.entity.FooBar;
import com.theone.example.foobar.param.FooBarPageParam;
import com.theone.example.foobar.service.FooBarService;
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
 * FooBar 控制器
 *
 * @author geekidea
 * @since 2020-03-24
 */
@Slf4j
@RestController
@RequestMapping("/fooBar")
@Module("foobar")
public class FooBarController extends BaseController {

    @Autowired
    private FooBarService fooBarService;

    /**
     * 添加FooBar
     */
    @PostMapping("/add")
    @OperationLog(name = "添加FooBar", type = OperationLogType.ADD)

    public ApiResult<Boolean> addFooBar(@Validated(Add.class) @RequestBody FooBar fooBar) throws Exception {
        boolean flag = fooBarService.saveFooBar(fooBar);
        return ApiResult.result(flag);
    }

    /**
     * 修改FooBar
     */
    @PostMapping("/update")
    @OperationLog(name = "修改FooBar", type = OperationLogType.UPDATE)

    public ApiResult<Boolean> updateFooBar(@Validated(Update.class) @RequestBody FooBar fooBar) throws Exception {
        boolean flag = fooBarService.updateFooBar(fooBar);
        return ApiResult.result(flag);
    }

    /**
     * 删除FooBar
     */
    @PostMapping("/delete/{id}")
    @OperationLog(name = "删除FooBar", type = OperationLogType.DELETE)

    public ApiResult<Boolean> deleteFooBar(@PathVariable("id") Long id) throws Exception {
        boolean flag = fooBarService.deleteFooBar(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取FooBar详情
     */
    @GetMapping("/info/{id}")
    @OperationLog(name = "FooBar详情", type = OperationLogType.INFO)

    public ApiResult<FooBar> getFooBar(@PathVariable("id") Long id) throws Exception {
        FooBar fooBar = fooBarService.getById(id);
        return ApiResult.ok(fooBar);
    }

    /**
     * FooBar分页列表
     */
    @PostMapping("/getPageList")
    @OperationLog(name = "FooBar分页列表", type = OperationLogType.PAGE)

    public ApiResult<Paging<FooBar>> getFooBarPageList(@Validated @RequestBody FooBarPageParam fooBarPageParam) throws Exception {
        Paging<FooBar> paging = fooBarService.getFooBarPageList(fooBarPageParam);
        return ApiResult.ok(paging);
    }

}

