package cn.leekoko.service;

import cn.leekoko.pojo.LifegameUser;

public interface LifeGameUserService {
	//获取单个用户
	LifegameUser get();
	boolean changePlanDay();
	//获取当前总金额
	Integer getCurMoney();
	//改变金额
	boolean changeMoney(Integer changeNum);
}
