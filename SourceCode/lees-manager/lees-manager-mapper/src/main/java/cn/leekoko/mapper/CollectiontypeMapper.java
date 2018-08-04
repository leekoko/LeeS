package cn.leekoko.mapper;

import cn.leekoko.pojo.Collectiontype;
import cn.leekoko.pojo.CollectiontypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CollectiontypeMapper {
    int countByExample(CollectiontypeExample example);

    int deleteByExample(CollectiontypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Collectiontype record);

    int insertSelective(Collectiontype record);

    List<Collectiontype> selectByExample(CollectiontypeExample example);

    Collectiontype selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Collectiontype record, @Param("example") CollectiontypeExample example);

    int updateByExample(@Param("record") Collectiontype record, @Param("example") CollectiontypeExample example);

    int updateByPrimaryKeySelective(Collectiontype record);

    int updateByPrimaryKey(Collectiontype record);
}