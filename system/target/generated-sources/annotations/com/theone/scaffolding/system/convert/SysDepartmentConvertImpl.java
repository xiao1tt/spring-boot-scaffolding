package com.theone.scaffolding.system.convert;

import com.theone.scaffolding.system.entity.SysDepartment;
import com.theone.scaffolding.system.vo.SysDepartmentTreeVo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-28T19:51:51+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_281 (Oracle Corporation)"
)
public class SysDepartmentConvertImpl implements SysDepartmentConvert {

    @Override
    public SysDepartmentTreeVo entityToTreeVo(SysDepartment sysDepartment) {
        if ( sysDepartment == null ) {
            return null;
        }

        SysDepartmentTreeVo sysDepartmentTreeVo = new SysDepartmentTreeVo();

        sysDepartmentTreeVo.setId( sysDepartment.getId() );
        sysDepartmentTreeVo.setName( sysDepartment.getName() );
        sysDepartmentTreeVo.setParentId( sysDepartment.getParentId() );
        sysDepartmentTreeVo.setState( sysDepartment.getState() );
        sysDepartmentTreeVo.setSort( sysDepartment.getSort() );
        sysDepartmentTreeVo.setRemark( sysDepartment.getRemark() );
        sysDepartmentTreeVo.setVersion( sysDepartment.getVersion() );
        sysDepartmentTreeVo.setCreateTime( sysDepartment.getCreateTime() );
        sysDepartmentTreeVo.setUpdateTime( sysDepartment.getUpdateTime() );

        return sysDepartmentTreeVo;
    }

    @Override
    public List<SysDepartmentTreeVo> listToTreeVoList(List<SysDepartment> list) {
        if ( list == null ) {
            return null;
        }

        List<SysDepartmentTreeVo> list1 = new ArrayList<SysDepartmentTreeVo>( list.size() );
        for ( SysDepartment sysDepartment : list ) {
            list1.add( entityToTreeVo( sysDepartment ) );
        }

        return list1;
    }
}
