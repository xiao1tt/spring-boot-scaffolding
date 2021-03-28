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

package com.theone.scaffolding.system.controller;

import com.theone.scaffolding.framework.common.api.ApiResult;
import com.theone.scaffolding.framework.common.controller.BaseController;
import com.theone.scaffolding.framework.core.pagination.Paging;
import com.theone.scaffolding.framework.core.validator.groups.Add;
import com.theone.scaffolding.framework.core.validator.groups.Update;
import com.theone.scaffolding.framework.log.annotation.Module;
import com.theone.scaffolding.framework.log.annotation.OperationLog;
import com.theone.scaffolding.framework.log.enums.OperationLogType;
import com.theone.scaffolding.system.entity.SysRole;
import com.theone.scaffolding.system.param.sysrole.SysRolePageParam;
import com.theone.scaffolding.system.param.sysrole.UpdateSysRolePermissionParam;
import com.theone.scaffolding.system.service.SysRoleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <pre>
 * 系统角色 前端控制器
 * </pre>
 *
 * @author geekidea
 * @since 2019-10-24
 */
@Slf4j
@RestController
@RequestMapping("/sysRole")
@Module("system")
public class SysRoleController extends BaseController {

    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 添加系统角色
     */
    @PostMapping("/add")
    @RequiresPermissions("sys:role:add")
    @OperationLog(name = "添加系统角色", type = OperationLogType.ADD)
    public ApiResult<Boolean> addSysRole(@Validated(Add.class) @RequestBody SysRole sysRole) throws Exception {
        boolean flag = sysRoleService.saveSysRole(sysRole);
        return ApiResult.result(flag);
    }

    /**
     * 修改系统角色
     */
    @PostMapping("/update")
    @RequiresPermissions("sys:role:update")
    @OperationLog(name = "修改系统角色", type = OperationLogType.UPDATE)
    public ApiResult<Boolean> updateSysRole(@Validated(Update.class) @RequestBody SysRole sysRole) throws Exception {
        boolean flag = sysRoleService.updateSysRole(sysRole);
        return ApiResult.result(flag);
    }

    /**
     * 删除系统角色
     */
    @PostMapping("/delete/{id}")
    @RequiresPermissions("sys:role:delete")
    @OperationLog(name = "删除系统角色", type = OperationLogType.DELETE)
    public ApiResult<Boolean> deleteSysRole(@PathVariable("id") Long id) throws Exception {
        boolean flag = sysRoleService.deleteSysRole(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取系统角色
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("sys:role:info")
    @OperationLog(name = "系统角色详情", type = OperationLogType.INFO)
    public ApiResult<SysRole> getSysRole(@PathVariable("id") Long id) throws Exception {
        SysRole sysRole = sysRoleService.getById(id);
        return ApiResult.ok(sysRole);
    }

    /**
     * 系统角色分页列表
     */
    @PostMapping("/getPageList")
    @RequiresPermissions("sys:role:page")
    @OperationLog(name = "系统角色分页列表", type = OperationLogType.PAGE)
    public ApiResult<Paging<SysRole>> getSysRolePageList(@Validated @RequestBody SysRolePageParam sysRolePageParam) throws Exception {
        Paging<SysRole> paging = sysRoleService.getSysRolePageList(sysRolePageParam);
        return ApiResult.ok(paging);
    }

    /**
     * 获取系统角色列表
     *
     * @return
     */
    @PostMapping("/getList")
    @RequiresPermissions("sys:role:list")
    @OperationLog(name = "系统角色列表", type = OperationLogType.LIST)
    public ApiResult<List<SysRole>> getRoleList() {
        return ApiResult.ok(sysRoleService.list());
    }

    /**
     * 修改系统角色权限
     */
    @PostMapping("/updateSysRolePermission")
    @RequiresPermissions("sys:role-permission:update")
    @OperationLog(name = "修改系统角色权限", type = OperationLogType.UPDATE)
    public ApiResult<Boolean> updateSysRolePermission(@Validated @RequestBody UpdateSysRolePermissionParam param) throws Exception {
        boolean flag = sysRoleService.updateSysRolePermission(param);
        return ApiResult.result(flag);
    }

}

