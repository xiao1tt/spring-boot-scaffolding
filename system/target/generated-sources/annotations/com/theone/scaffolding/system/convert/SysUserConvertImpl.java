package com.theone.scaffolding.system.convert;

import com.theone.scaffolding.framework.shiro.vo.LoginSysUserVo;
import com.theone.scaffolding.system.entity.SysUser;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-28T19:51:51+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_281 (Oracle Corporation)"
)
public class SysUserConvertImpl implements SysUserConvert {

    @Override
    public LoginSysUserVo sysUserToLoginSysUserVo(SysUser sysUser) {
        if ( sysUser == null ) {
            return null;
        }

        LoginSysUserVo loginSysUserVo = new LoginSysUserVo();

        loginSysUserVo.setId( sysUser.getId() );
        loginSysUserVo.setUsername( sysUser.getUsername() );
        loginSysUserVo.setNickname( sysUser.getNickname() );
        loginSysUserVo.setGender( sysUser.getGender() );
        loginSysUserVo.setState( sysUser.getState() );
        loginSysUserVo.setDepartmentId( sysUser.getDepartmentId() );
        loginSysUserVo.setRoleId( sysUser.getRoleId() );

        return loginSysUserVo;
    }
}
