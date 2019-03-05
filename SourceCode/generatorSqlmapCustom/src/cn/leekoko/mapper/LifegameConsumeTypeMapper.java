package cn.leekoko.mapper;

import cn.leekoko.pojo.LifegameConsumeType;
import cn.leekoko.pojo.LifegameConsumeTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LifegameConsumeTypeMapper {
    int countByExample(LifegameConsumeTypeExample example);

    int deleteByExample(LifegameConsumeTypeExample example);

    int deleteByPrimaryKey(String code);

    int insert(LifegameConsumeType record);

    int insertSelective(LifegameConsumeType record);

    List<LifegameConsumeType> selectByExample(LifegameConsumeTypeExample example);

    LifegameConsumeType selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") LifegameConsumeType record, @Param("example") LifegameConsumeTypeExample example);

    int updateByExample(@Param("record") LifegameConsumeType record, @Param("example") LifegameConsumeTypeExample example);

    int updateByPrimaryKeySelective(LifegameConsumeType record);

    int updateByPrimaryKey(LifegameConsumeType record);
}