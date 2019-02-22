package cn.leekoko.mapper;

import cn.leekoko.pojo.Templateflow;
import cn.leekoko.pojo.TemplateflowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TemplateflowMapper {
    int countByExample(TemplateflowExample example);

    int deleteByExample(TemplateflowExample example);

    int deleteByPrimaryKey(String code);

    int insert(Templateflow record);

    int insertSelective(Templateflow record);

    List<Templateflow> selectByExample(TemplateflowExample example);

    Templateflow selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") Templateflow record, @Param("example") TemplateflowExample example);

    int updateByExample(@Param("record") Templateflow record, @Param("example") TemplateflowExample example);

    int updateByPrimaryKeySelective(Templateflow record);

    int updateByPrimaryKey(Templateflow record);
}