package cn.leekoko.service;

import java.util.List;

import cn.leekoko.pojo.Onlinecontent;

public interface OnlinecontentService{
	List<String> getContentList();
	void insertSelective(Onlinecontent onlinecontent);
	//���������Ϣ
	void delete();
}
