package cn.leekoko.service;

import cn.leekoko.pojo.LifegameTempplan;

import java.util.HashMap;
import java.util.List;

public interface LifeGameTempPlanService {
	HashMap<String,Object> save(LifegameTempplan lifegameTempplan, boolean isToday);
	List<LifegameTempplan> getTodayAllPlan();
    HashMap<String, Object> changeStatu(LifegameTempplan lifegameTempplan);
	List<LifegameTempplan> getTodayChosePlan();
	List<LifegameTempplan> getTodayOldPlan();
	//备份旧计划
	boolean backUpOldPlan();
	//	插入固定plan到临时计划表中
	boolean insertNewPlan();

}
