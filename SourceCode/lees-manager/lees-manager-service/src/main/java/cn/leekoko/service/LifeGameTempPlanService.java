package cn.leekoko.service;

import cn.leekoko.pojo.LifegamePlan;
import cn.leekoko.pojo.LifegameTempplan;

import java.util.HashMap;
import java.util.List;

public interface LifeGameTempPlanService {
	HashMap<String,Object> save(LifegameTempplan lifegameTempplan);
	List<LifegameTempplan> getTodayAllPlan();
    HashMap<String, Object> changeStatu(LifegameTempplan lifegameTempplan);
	List<LifegameTempplan> getTodayChosePlan();

}
