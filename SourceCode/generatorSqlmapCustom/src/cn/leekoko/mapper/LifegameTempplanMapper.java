package cn.leekoko.mapper;

import cn.leekoko.pojo.LifegameTempplan;
import cn.leekoko.pojo.LifegameTempplanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LifegameTempplanMapper {
    int countByExample(LifegameTempplanExample example);

    int deleteByExample(LifegameTempplanExample example);

    int deleteByPrimaryKey(String code);

    int insert(LifegameTempplan record);

    int insertSelective(LifegameTempplan record);

    List<LifegameTempplan> selectByExampleWithBLOBs(LifegameTempplanExample example);

    List<LifegameTempplan> selectByExample(LifegameTempplanExample example);

    LifegameTempplan selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") LifegameTempplan record, @Param("example") LifegameTempplanExample example);

    int updateByExampleWithBLOBs(@Param("record") LifegameTempplan record, @Param("example") LifegameTempplanExample example);

    int updateByExample(@Param("record") LifegameTempplan record, @Param("example") LifegameTempplanExample example);

    int updateByPrimaryKeySelective(LifegameTempplan record);

    int updateByPrimaryKeyWithBLOBs(LifegameTempplan record);

    int updateByPrimaryKey(LifegameTempplan record);
}