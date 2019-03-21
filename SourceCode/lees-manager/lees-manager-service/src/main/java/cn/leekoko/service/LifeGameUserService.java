package cn.leekoko.service;

import cn.leekoko.pojo.LifegameUser;

public interface LifeGameUserService {
	//获取单个用户
	LifegameUser get(String userName);

	boolean changePlanDay(String userName);
	//获取当前总金额
	Integer getCurMoney(String userName);
	//改变金额
	boolean changeMoney(Integer changeNum, String userName);
	//用户检查登录
	LifegameUser checkLogin(LifegameUser lifegameUser);
}
