package cn.leekoko.service.impl;

import cn.leekoko.mapper.CollectioncontentMapper;
import cn.leekoko.pojo.Collectioncontent;
import cn.leekoko.pojo.CollectioncontentExample;
import cn.leekoko.pojo.CollectioncontentExample.Criteria;
import cn.leekoko.service.CollectioncontentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectioncontentServiceImpl implements CollectioncontentService {

	@Autowired
	private CollectioncontentMapper collectioncontentMapper;
	
	public List<Collectioncontent> getByList(int parentId) {
		CollectioncontentExample example = new CollectioncontentExample();
		example.setOrderByClause("clickDate desc");   //…Ë÷√≈≈–Ú
		Criteria criteria = example.createCriteria();		
		criteria.andParentidEqualTo(parentId);
		return collectioncontentMapper.selectByExample(example);
	}

	public int insertSelective(Collectioncontent record) {
		return collectioncontentMapper.insertSelective(record);
	}

	public int updateByExampleSelective(Collectioncontent record, CollectioncontentExample example) {
		return collectioncontentMapper.updateByExampleSelective(record, example);
	}

}
