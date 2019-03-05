package cn.leekoko.mapper;

import cn.leekoko.pojo.LifegameConsume;
import cn.leekoko.pojo.LifegameConsumeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LifegameConsumeMapper {
    int countByExample(LifegameConsumeExample example);

    int deleteByExample(LifegameConsumeExample example);

    int deleteByPrimaryKey(String code);

    int insert(LifegameConsume record);

    int insertSelective(LifegameConsume record);

    List<LifegameConsume> selectByExample(LifegameConsumeExample example);

    LifegameConsume selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") LifegameConsume record, @Param("example") LifegameConsumeExample example);

    int updateByExample(@Param("record") LifegameConsume record, @Param("example") LifegameConsumeExample example);

    int updateByPrimaryKeySelective(LifegameConsume record);

    int updateByPrimaryKey(LifegameConsume record);
}