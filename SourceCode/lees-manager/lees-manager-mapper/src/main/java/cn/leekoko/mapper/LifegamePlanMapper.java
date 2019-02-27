package cn.leekoko.mapper;

import cn.leekoko.pojo.LifegamePlan;
import cn.leekoko.pojo.LifegamePlanExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LifegamePlanMapper {
    int countByExample(LifegamePlanExample example);

    int deleteByExample(LifegamePlanExample example);

    int deleteByPrimaryKey(String code);

    int insert(LifegamePlan record);

    int insertSelective(LifegamePlan record);

    List<LifegamePlan> selectByExampleWithBLOBs(LifegamePlanExample example);

    List<LifegamePlan> selectByExample(LifegamePlanExample example);

    LifegamePlan selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") LifegamePlan record, @Param("example") LifegamePlanExample example);

    int updateByExampleWithBLOBs(@Param("record") LifegamePlan record, @Param("example") LifegamePlanExample example);

    int updateByExample(@Param("record") LifegamePlan record, @Param("example") LifegamePlanExample example);

    int updateByPrimaryKeySelective(LifegamePlan record);

    int updateByPrimaryKeyWithBLOBs(LifegamePlan record);

    int updateByPrimaryKey(LifegamePlan record);
}