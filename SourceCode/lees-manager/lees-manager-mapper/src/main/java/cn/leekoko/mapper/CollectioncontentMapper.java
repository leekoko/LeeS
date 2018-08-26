package cn.leekoko.mapper;

import cn.leekoko.pojo.Collectioncontent;
import cn.leekoko.pojo.CollectioncontentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CollectioncontentMapper {
    int countByExample(CollectioncontentExample example);

    int deleteByExample(CollectioncontentExample example);

    int deleteByPrimaryKey(String id);

    int insert(Collectioncontent record);

    int insertSelective(Collectioncontent record);

    List<Collectioncontent> selectByExample(CollectioncontentExample example);

    Collectioncontent selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Collectioncontent record, @Param("example") CollectioncontentExample example);

    int updateByExample(@Param("record") Collectioncontent record, @Param("example") CollectioncontentExample example);

    int updateByPrimaryKeySelective(Collectioncontent record);

    int updateByPrimaryKey(Collectioncontent record);
}