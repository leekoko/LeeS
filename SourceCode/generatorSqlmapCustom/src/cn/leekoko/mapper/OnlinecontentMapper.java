package cn.leekoko.mapper;

import cn.leekoko.pojo.Onlinecontent;
import cn.leekoko.pojo.OnlinecontentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OnlinecontentMapper {
    int countByExample(OnlinecontentExample example);

    int deleteByExample(OnlinecontentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Onlinecontent record);

    int insertSelective(Onlinecontent record);

    List<Onlinecontent> selectByExample(OnlinecontentExample example);

    Onlinecontent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Onlinecontent record, @Param("example") OnlinecontentExample example);

    int updateByExample(@Param("record") Onlinecontent record, @Param("example") OnlinecontentExample example);

    int updateByPrimaryKeySelective(Onlinecontent record);

    int updateByPrimaryKey(Onlinecontent record);
}