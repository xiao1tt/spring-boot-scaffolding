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

import com.theone.scaffolding.config.properties.SpringBootPlusProperties;
import com.theone.scaffolding.framework.common.api.ApiResult;
import com.theone.scaffolding.framework.common.controller.BaseController;
import com.theone.scaffolding.framework.core.pagination.Paging;
import com.theone.scaffolding.framework.core.validator.groups.Add;
import com.theone.scaffolding.framework.core.validator.groups.Update;
import com.theone.scaffolding.framework.log.annotation.Module;
import com.theone.scaffolding.framework.log.annotation.OperationLog;
import com.theone.scaffolding.framework.log.enums.OperationLogType;
import com.theone.scaffolding.system.entity.SysUser;
import com.theone.scaffolding.system.param.sysuser.ResetPasswordParam;
import com.theone.scaffolding.system.param.sysuser.SysUserPageParam;
import com.theone.scaffolding.system.param.sysuser.UpdatePasswordParam;
import com.theone.scaffolding.system.param.sysuser.UploadHeadParam;
import com.theone.scaffolding.system.service.SysUserService;
import com.theone.scaffolding.system.vo.SysUserQueryVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <pre>
 * 系统用户 前端控制器
 * </pre>
 *
 * @author geekidea
 * @since 2019-10-24
 */
@Slf4j
@RestController
@RequestMapping("/sysUser")
@Module("system")
public class SysUserController extends BaseController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SpringBootPlusProperties springBootPlusProperties;

    /**
     * 添加系统用户
     */
    @PostMapping("/add")
    @RequiresPermissions("sys:user:add")
    @OperationLog(name = "添加系统用户", type = OperationLogType.ADD)
    public ApiResult<Boolean> addSysUser(@Validated(Add.class) @RequestBody SysUser sysUser) throws Exception {
        boolean flag = sysUserService.saveSysUser(sysUser);
        return ApiResult.result(flag);
    }

    /**
     * 修改系统用户
     */
    @PostMapping("/update")
    @RequiresPermissions("sys:user:update")
    @OperationLog(name = "修改系统用户", type = OperationLogType.UPDATE)
    public ApiResult<Boolean> updateSysUser(@Validated(Update.class) @RequestBody SysUser sysUser) throws Exception {
        boolean flag = sysUserService.updateSysUser(sysUser);
        return ApiResult.result(flag);
    }

    /**
     * 删除系统用户
     */
    @PostMapping("/delete/{id}")
    @RequiresPermissions("sys:user:delete")
    @OperationLog(name = "删除系统用户", type = OperationLogType.DELETE)
    public ApiResult<Boolean> deleteSysUser(@PathVariable("id") Long id) throws Exception {
        boolean flag = sysUserService.deleteSysUser(id);
        return ApiResult.result(flag);
    }


    /**
     * 根据id获取系统用户
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("sys:user:info:id")
    @OperationLog(name = "系统用户详情", type = OperationLogType.INFO)
    public ApiResult<SysUserQueryVo> getSysUser(@PathVariable("id") Long id) throws Exception {
        SysUserQueryVo sysUserQueryVo = sysUserService.getSysUserById(id);
        return ApiResult.ok(sysUserQueryVo);
    }

    /**
     * 系统用户分页列表
     */
    @PostMapping("/getPageList")
    @RequiresPermissions("sys:user:page")
    @OperationLog(name = "系统用户分页列表", type = OperationLogType.PAGE)
    public ApiResult<Paging<SysUserQueryVo>> getSysUserPageList(@Validated @RequestBody SysUserPageParam sysUserPageParam) throws Exception {
        Paging<SysUserQueryVo> paging = sysUserService.getSysUserPageList(sysUserPageParam);
        return ApiResult.ok(paging);
    }

    /**
     * 修改密码
     */
    @PostMapping("/updatePassword")
    @RequiresPermissions("sys:user:update:password")
    @OperationLog(name = "修改密码", type = OperationLogType.UPDATE)
    public ApiResult<Boolean> updatePassword(@Validated @RequestBody UpdatePasswordParam updatePasswordParam) throws Exception {
        boolean flag = sysUserService.updatePassword(updatePasswordParam);
        return ApiResult.result(flag);
    }

    /**
     * 管理员重置用户密码
     */
    @PostMapping("/resetPassword")
    @RequiresPermissions("sys:user:reset:password")
    @OperationLog(name = "管理员重置用户密码", type = OperationLogType.UPDATE)
    public ApiResult<Boolean> resetPassword(@Validated @RequestBody ResetPasswordParam resetPasswordParam) throws Exception {
        boolean flag = sysUserService.resetPassword(resetPasswordParam);
        return ApiResult.result(flag);
    }

    /**
     * 修改头像
     */
    @PostMapping("/uploadHead")
    @RequiresPermissions("sys:user:update:head")
    @OperationLog(name = "修改头像", type = OperationLogType.UPDATE)
    public ApiResult<Boolean> uploadHead(@Validated @RequestBody UploadHeadParam uploadHeadParam) throws Exception {
        boolean flag = sysUserService.updateSysUserHead(uploadHeadParam.getId(), uploadHeadParam.getHead());
        return ApiResult.result(flag);
    }
}

