package cn.leekoko.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.leekoko.mapper.OnlinecontentMapper;
import cn.leekoko.pojo.Onlinecontent;
import cn.leekoko.pojo.OnlinecontentExample;
import cn.leekoko.service.OnlinecontentService;

@Service
public class OnlinecontentServiceImpl implements OnlinecontentService{
	
	@Autowired
	private OnlinecontentMapper onlinecontentMapper;
	
	public List<String> getContentList() {
		
		OnlinecontentExample example = new OnlinecontentExample();
		example.setOrderByClause("createTime desc");    //按创建时间从近到远
		List<Onlinecontent> onlineList = onlinecontentMapper.selectByExample(example);
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < onlineList.size(); i++) {
			list.add(onlineList.get(i).getContent());
		}
		return list;
	}

	public void insertSelective(Onlinecontent onlinecontent) {
		onlinecontentMapper.insertSelective(onlinecontent);
	}

	public void delete() {
		OnlinecontentExample example = new OnlinecontentExample();
		onlinecontentMapper.deleteByExample(example);
	}

}
