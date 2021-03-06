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

package com.theone.scaffolding.framework.log.controller;

import com.theone.scaffolding.framework.common.api.ApiResult;
import com.theone.scaffolding.framework.common.controller.BaseController;
import com.theone.scaffolding.framework.core.pagination.Paging;
import com.theone.scaffolding.framework.log.entity.SysOperationLog;
import com.theone.scaffolding.framework.log.param.SysOperationLogPageParam;
import com.theone.scaffolding.framework.log.service.SysOperationLogService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统操作日志 控制器
 *
 * @author geekidea
 * @since 2020-03-19
 */
@Slf4j
@RestController
@RequestMapping("/sysOperationLog")
public class SysOperationLogController extends BaseController {

    @Autowired
    private SysOperationLogService sysOperationLogService;

    /**
     * 系统操作日志分页列表
     */
    @PostMapping("/getPageList")
    @RequiresPermissions("sys:operation:log:page")
    public ApiResult<Paging<SysOperationLog>> getSysOperationLogPageList(@Validated @RequestBody SysOperationLogPageParam sysOperationLogPageParam) throws Exception {
        Paging<SysOperationLog> paging = sysOperationLogService.getSysOperationLogPageList(sysOperationLogPageParam);
        return ApiResult.ok(paging);
    }

}

