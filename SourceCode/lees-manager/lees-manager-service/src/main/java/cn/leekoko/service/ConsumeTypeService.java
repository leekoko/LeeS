package cn.leekoko.service;

import cn.leekoko.pojo.LifegameConsumeType;

import java.util.HashMap;
import java.util.List;

public interface ConsumeTypeService {
	HashMap<String, Object> save(LifegameConsumeType lifegameConsumeType);
	List<LifegameConsumeType> findList(String userCode);
	boolean delType(String code);
}
