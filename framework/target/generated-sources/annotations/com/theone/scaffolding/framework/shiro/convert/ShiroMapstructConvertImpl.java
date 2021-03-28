package com.theone.scaffolding.framework.shiro.convert;

import com.theone.scaffolding.framework.shiro.jwt.JwtToken;
import com.theone.scaffolding.framework.shiro.vo.JwtTokenRedisVo;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-28T19:51:49+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_281 (Oracle Corporation)"
)
public class ShiroMapstructConvertImpl implements ShiroMapstructConvert {

    @Override
    public JwtTokenRedisVo jwtTokenToJwtTokenRedisVo(JwtToken jwtToken) {
        if ( jwtToken == null ) {
            return null;
        }

        JwtTokenRedisVo jwtTokenRedisVo = new JwtTokenRedisVo();

        jwtTokenRedisVo.setHost( jwtToken.getHost() );
        jwtTokenRedisVo.setUsername( jwtToken.getUsername() );
        jwtTokenRedisVo.setSalt( jwtToken.getSalt() );
        jwtTokenRedisVo.setToken( jwtToken.getToken() );
        jwtTokenRedisVo.setCreateDate( jwtToken.getCreateDate() );
        jwtTokenRedisVo.setExpireSecond( jwtToken.getExpireSecond() );
        jwtTokenRedisVo.setExpireDate( jwtToken.getExpireDate() );

        return jwtTokenRedisVo;
    }
}
