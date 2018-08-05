package cn.leekoko.service;

import java.util.List;

import cn.leekoko.pojo.Collectiontype;

public interface CollectionTypeService {
	List<Collectiontype> getTypeList();
    int insertSelective(Collectiontype record);
}
