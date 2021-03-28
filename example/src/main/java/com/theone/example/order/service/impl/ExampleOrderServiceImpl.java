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

package com.theone.example.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.theone.example.order.entity.ExampleOrder;
import com.theone.example.order.mapper.ExampleOrderMapper;
import com.theone.example.order.param.ExampleOrderPageParam;
import com.theone.example.order.service.ExampleOrderService;
import  com.theone.scaffolding.framework.common.service.impl.BaseServiceImpl;
import  com.theone.scaffolding.framework.core.pagination.PageInfo;
import  com.theone.scaffolding.framework.core.pagination.Paging;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 订单示例 服务实现类
 *
 * @author geekidea
 * @since 2020-03-27
 */
@Slf4j
@Service
public class ExampleOrderServiceImpl extends BaseServiceImpl<ExampleOrderMapper, ExampleOrder> implements ExampleOrderService {

    @Autowired
    private ExampleOrderMapper exampleOrderMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveExampleOrder(ExampleOrder exampleOrder) throws Exception {
        return super.save(exampleOrder);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateExampleOrder(ExampleOrder exampleOrder) throws Exception {
        return super.updateById(exampleOrder);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteExampleOrder(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public Paging<ExampleOrder> getExampleOrderPageList(ExampleOrderPageParam exampleOrderPageParam) throws Exception {
        Page<ExampleOrder> page = new PageInfo<>(exampleOrderPageParam, OrderItem.desc(getLambdaColumn(ExampleOrder::getCreateTime)));
        LambdaQueryWrapper<ExampleOrder> wrapper = new LambdaQueryWrapper<>();
        String keyword = exampleOrderPageParam.getKeyword();
        String name = exampleOrderPageParam.getName();
        String orderNo = exampleOrderPageParam.getOrderNo();
        // keyword模糊查询
        if (StringUtils.isNotBlank(keyword)) {
            wrapper.like(ExampleOrder::getName, keyword).or().like(ExampleOrder::getOrderNo, keyword);
        }
        // name模糊查询
        if (StringUtils.isNotBlank(name)) {
            wrapper.like(ExampleOrder::getName, name);
        }
        // 订单号模糊查询
        if (StringUtils.isNotBlank(orderNo)) {
            wrapper.like(ExampleOrder::getOrderNo, orderNo);
        }
        IPage<ExampleOrder> iPage = exampleOrderMapper.selectPage(page, wrapper);
        return new Paging<ExampleOrder>(iPage);
    }

}
