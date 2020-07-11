package xyz.herther.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import xyz.herther.pojo.TbRolesMenusExample;
import xyz.herther.pojo.TbRolesMenusKey;

public interface TbRolesMenusMapper {
    long countByExample(TbRolesMenusExample example);

    int deleteByExample(TbRolesMenusExample example);

    int deleteByPrimaryKey(TbRolesMenusKey key);

    int insert(TbRolesMenusKey record);

    int insertSelective(TbRolesMenusKey record);

    List<TbRolesMenusKey> selectByExample(TbRolesMenusExample example);

    int updateByExampleSelective(@Param("record") TbRolesMenusKey record, @Param("example") TbRolesMenusExample example);

    int updateByExample(@Param("record") TbRolesMenusKey record, @Param("example") TbRolesMenusExample example);
}