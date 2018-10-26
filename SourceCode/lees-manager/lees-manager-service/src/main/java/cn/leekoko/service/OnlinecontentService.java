package cn.leekoko.service;

import java.util.List;

import cn.leekoko.pojo.Onlinecontent;

public interface OnlinecontentService{
	List<String> getContentList();
	void insertSelective(Onlinecontent onlinecontent);
	//清空所有信息
	void delete();
}
