package com.theone.scaffolding.system.convert;

import com.theone.scaffolding.system.entity.SysPermission;
import com.theone.scaffolding.system.vo.SysPermissionTreeVo;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-28T19:51:51+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_281 (Oracle Corporation)"
)
public class SysPermissionConvertImpl implements SysPermissionConvert {

    @Override
    public SysPermissionTreeVo permissionToTreeVo(SysPermission sysPermission) {
        if ( sysPermission == null ) {
            return null;
        }

        SysPermissionTreeVo sysPermissionTreeVo = new SysPermissionTreeVo();

        sysPermissionTreeVo.setId( sysPermission.getId() );
        sysPermissionTreeVo.setName( sysPermission.getName() );
        sysPermissionTreeVo.setParentId( sysPermission.getParentId() );
        sysPermissionTreeVo.setUrl( sysPermission.getUrl() );
        sysPermissionTreeVo.setCode( sysPermission.getCode() );
        sysPermissionTreeVo.setIcon( sysPermission.getIcon() );
        sysPermissionTreeVo.setType( sysPermission.getType() );
        sysPermissionTreeVo.setLevel( sysPermission.getLevel() );
        sysPermissionTreeVo.setState( sysPermission.getState() );
        sysPermissionTreeVo.setSort( sysPermission.getSort() );
        sysPermissionTreeVo.setRemark( sysPermission.getRemark() );
        sysPermissionTreeVo.setVersion( sysPermission.getVersion() );
        sysPermissionTreeVo.setCreateTime( sysPermission.getCreateTime() );
        sysPermissionTreeVo.setUpdateTime( sysPermission.getUpdateTime() );

        return sysPermissionTreeVo;
    }
}
