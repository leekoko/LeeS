package cn.leekoko.service;

import cn.leekoko.pojo.LifegamePlan;

import java.util.HashMap;
import java.util.List;

public interface LifeGamePlanService {
	HashMap<String, Object> save(LifegamePlan lifegamePlan);
	List<LifegamePlan> findList(String type, String userCode);
	HashMap<String, Object> delete(String code);

}
