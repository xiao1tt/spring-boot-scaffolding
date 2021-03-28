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

package com.theone.scaffolding.system.vo;

import com.theone.scaffolding.framework.shiro.service.LoginToken;
import com.theone.scaffolding.framework.shiro.vo.LoginSysUserVo;


import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author geekidea
 * @date 2019-10-26
 **/
@Data
@Accessors(chain = true)

public class LoginSysUserTokenVo implements LoginToken {

    private static final long serialVersionUID = -2138450422989081056L;


    private String token;

    /**
     * 登录用户对象
     */
    private LoginSysUserVo loginSysUserVo;
}
