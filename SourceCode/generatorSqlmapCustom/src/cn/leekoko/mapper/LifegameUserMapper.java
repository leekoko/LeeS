package cn.leekoko.mapper;

import cn.leekoko.pojo.LifegameUser;
import cn.leekoko.pojo.LifegameUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LifegameUserMapper {
    int countByExample(LifegameUserExample example);

    int deleteByExample(LifegameUserExample example);

    int deleteByPrimaryKey(String code);

    int insert(LifegameUser record);

    int insertSelective(LifegameUser record);

    List<LifegameUser> selectByExample(LifegameUserExample example);

    LifegameUser selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") LifegameUser record, @Param("example") LifegameUserExample example);

    int updateByExample(@Param("record") LifegameUser record, @Param("example") LifegameUserExample example);

    int updateByPrimaryKeySelective(LifegameUser record);

    int updateByPrimaryKey(LifegameUser record);
}