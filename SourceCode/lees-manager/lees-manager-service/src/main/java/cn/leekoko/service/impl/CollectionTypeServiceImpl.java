package cn.leekoko.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.leekoko.mapper.CollectiontypeMapper;
import cn.leekoko.pojo.Collectiontype;
import cn.leekoko.pojo.CollectiontypeExample;
import cn.leekoko.service.CollectionTypeService;
@Service
public class CollectionTypeServiceImpl implements CollectionTypeService {
	
	@Autowired
	private CollectiontypeMapper collectiontypeMapper;
	
	public List<Collectiontype> getTypeList() {
		CollectiontypeExample example = new CollectiontypeExample();
		return collectiontypeMapper.selectByExample(example);
	}

	public int insertSelective(Collectiontype record) {
		return collectiontypeMapper.insertSelective(record);
	}

}
