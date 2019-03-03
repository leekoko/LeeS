package cn.leekoko.service;

import cn.leekoko.pojo.LifegameUser;

public interface LifeGameUserService {
	//获取单个用户
	LifegameUser get();
	boolean changePlanDay();
}
