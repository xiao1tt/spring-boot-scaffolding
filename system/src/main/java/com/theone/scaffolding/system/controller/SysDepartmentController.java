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
import com.theone.scaffolding.framework.log.annotation.Module;
import com.theone.scaffolding.framework.log.annotation.OperationLog;
import com.theone.scaffolding.framework.log.enums.OperationLogType;
import com.theone.scaffolding.system.entity.SysDepartment;
import com.theone.scaffolding.system.param.SysDepartmentPageParam;
import com.theone.scaffolding.system.service.SysDepartmentService;
import com.theone.scaffolding.system.vo.SysDepartmentQueryVo;
import com.theone.scaffolding.system.vo.SysDepartmentTreeVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <pre>
 * 部门 前端控制器
 * </pre>
 *
 * @author geekidea
 * @since 2019-10-24
 */
@Slf4j
@RestController
@RequestMapping("/sysDepartment")
@Module("system")
public class SysDepartmentController extends BaseController {

    @Autowired
    private SysDepartmentService sysDepartmentService;

    /**
     * 添加部门
     */
    @PostMapping("/add")
    @RequiresPermissions("sys:department:add")
    @OperationLog(name = "添加部门", type = OperationLogType.ADD)
    public ApiResult<Boolean> addSysDepartment(@Validated @RequestBody SysDepartment sysDepartment) throws Exception {
        boolean flag = sysDepartmentService.saveSysDepartment(sysDepartment);
        return ApiResult.result(flag);
    }

    /**
     * 修改部门
     */
    @PostMapping("/update")
    @RequiresPermissions("sys:department:update")
    @OperationLog(name = "修改部门", type = OperationLogType.UPDATE)
    public ApiResult<Boolean> updateSysDepartment(@Validated @RequestBody SysDepartment sysDepartment) throws Exception {
        boolean flag = sysDepartmentService.updateSysDepartment(sysDepartment);
        return ApiResult.result(flag);
    }

    /**
     * 删除部门
     */
    @PostMapping("/delete/{id}")
    @RequiresPermissions("sys:department:delete")
    @OperationLog(name = "删除部门", type = OperationLogType.DELETE)
    public ApiResult<Boolean> deleteSysDepartment(@PathVariable("id") Long id) throws Exception {
        boolean flag = sysDepartmentService.deleteSysDepartment(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取部门
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("sys:department:info")
    @OperationLog(name = "部门详情", type = OperationLogType.INFO)
    public ApiResult<SysDepartmentQueryVo> getSysDepartment(@PathVariable("id") Long id) throws Exception {
        SysDepartmentQueryVo sysDepartmentQueryVo = sysDepartmentService.getSysDepartmentById(id);
        return ApiResult.ok(sysDepartmentQueryVo);
    }

    /**
     * 部门分页列表
     */
    @PostMapping("/getPageList")
    @RequiresPermissions("sys:department:page")
    @OperationLog(name = "部门分页列表", type = OperationLogType.PAGE)
    public ApiResult<Paging<SysDepartmentQueryVo>> getSysDepartmentPageList(@Validated @RequestBody SysDepartmentPageParam sysDepartmentPageParam) throws Exception {
        Paging<SysDepartmentQueryVo> paging = sysDepartmentService.getSysDepartmentPageList(sysDepartmentPageParam);
        return ApiResult.ok(paging);
    }

    /**
     * 获取所有部门列表
     */
    @PostMapping("/getAllDepartmentList")
    @RequiresPermissions("sys:department:all:list")
    @OperationLog(name = "获取所有部门的树形列表", type = OperationLogType.OTHER_QUERY)
    public ApiResult<List<SysDepartment>> getAllDepartmentList() throws Exception {
        List<SysDepartment> list = sysDepartmentService.getAllDepartmentList();
        return ApiResult.ok(list);
    }

    /**
     * 获取所有部门的树形列表
     *
     * @return
     */
    @PostMapping("/getDepartmentTree")
    @RequiresPermissions("sys:department:all:tree")
    @OperationLog(name = "获取所有部门的树形列表", type = OperationLogType.OTHER_QUERY)
    public ApiResult<List<SysDepartmentTreeVo>> getDepartmentTree() throws Exception {
        List<SysDepartmentTreeVo> treeVos = sysDepartmentService.getDepartmentTree();
        return ApiResult.ok(treeVos);
    }

    /**
     * 部门列表
     */
    @PostMapping("/getList")
    @RequiresPermissions("sys:department:list")
    @OperationLog(name = "部门列表", type = OperationLogType.LIST)
    public ApiResult<List<SysDepartment>> getSysDepartmentList() throws Exception {
        List<SysDepartment> list = sysDepartmentService.list();
        return ApiResult.ok(list);
    }

}

