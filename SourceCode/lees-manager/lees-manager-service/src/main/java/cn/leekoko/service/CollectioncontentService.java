package cn.leekoko.service;

import java.util.List;

import cn.leekoko.pojo.Collectioncontent;
import cn.leekoko.pojo.CollectioncontentExample;

public interface CollectioncontentService {
	List<Collectioncontent> getByList(int parentId);
	int insertSelective(Collectioncontent record);
	int updateByExampleSelective(Collectioncontent record, CollectioncontentExample example);
}
