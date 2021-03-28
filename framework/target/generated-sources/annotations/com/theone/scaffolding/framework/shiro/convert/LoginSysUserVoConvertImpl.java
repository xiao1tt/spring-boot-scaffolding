package com.theone.scaffolding.framework.shiro.convert;

import com.theone.scaffolding.framework.shiro.vo.LoginSysUserRedisVo;
import com.theone.scaffolding.framework.shiro.vo.LoginSysUserVo;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-28T19:51:49+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_281 (Oracle Corporation)"
)
public class LoginSysUserVoConvertImpl implements LoginSysUserVoConvert {

    @Override
    public LoginSysUserRedisVo voToRedisVo(LoginSysUserVo loginSysUserVo) {
        if ( loginSysUserVo == null ) {
            return null;
        }

        LoginSysUserRedisVo loginSysUserRedisVo = new LoginSysUserRedisVo();

        loginSysUserRedisVo.setId( loginSysUserVo.getId() );
        loginSysUserRedisVo.setUsername( loginSysUserVo.getUsername() );
        loginSysUserRedisVo.setNickname( loginSysUserVo.getNickname() );
        loginSysUserRedisVo.setGender( loginSysUserVo.getGender() );
        loginSysUserRedisVo.setState( loginSysUserVo.getState() );
        loginSysUserRedisVo.setDepartmentId( loginSysUserVo.getDepartmentId() );
        loginSysUserRedisVo.setDepartmentName( loginSysUserVo.getDepartmentName() );
        loginSysUserRedisVo.setRoleId( loginSysUserVo.getRoleId() );
        loginSysUserRedisVo.setRoleName( loginSysUserVo.getRoleName() );
        loginSysUserRedisVo.setRoleCode( loginSysUserVo.getRoleCode() );
        Set<String> set = loginSysUserVo.getPermissionCodes();
        if ( set != null ) {
            loginSysUserRedisVo.setPermissionCodes( new HashSet<String>( set ) );
        }

        return loginSysUserRedisVo;
    }
}
