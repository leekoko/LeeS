package cn.leekoko.mapper;

import cn.leekoko.pojo.Library;
import cn.leekoko.pojo.LibraryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LibraryMapper {
    int countByExample(LibraryExample example);

    int deleteByExample(LibraryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Library record);

    int insertSelective(Library record);

    List<Library> selectByExample(LibraryExample example);

    Library selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Library record, @Param("example") LibraryExample example);

    int updateByExample(@Param("record") Library record, @Param("example") LibraryExample example);

    int updateByPrimaryKeySelective(Library record);

    int updateByPrimaryKey(Library record);
}