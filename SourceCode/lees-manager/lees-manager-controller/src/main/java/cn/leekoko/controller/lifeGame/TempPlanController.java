package cn.leekoko.controller.lifeGame;

import cn.leekoko.common.utils.DateUtil;
import cn.leekoko.pojo.LifegameTempplan;
import cn.leekoko.pojo.LifegameUser;
import cn.leekoko.service.LifeGameTempPlanService;
import cn.leekoko.service.LifeGameUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/tempPlan")
public class TempPlanController {

    @Autowired
    private LifeGameTempPlanService lifeGameTempPlanService;

    @Autowired
    private LifeGameUserService lifeGameUserService;

    /**
     * 计划列表页面
     * @param model
     * @return
     */
    @RequestMapping("/toDoList")
    public String toDoList(Model model, HttpServletRequest request){
        if(DateUtil.getDate().equals(lifeGameUserService.get("leekoko").getPlanDay())){
            //今日计划匹配才进入该页面
            return "lifeGame/startDoPage";
        }else{
            model.addAttribute("planList",lifeGameTempPlanService.getTodayAllPlan());
            return "lifeGame/toDoList";
        }
    }

    /**
     * 跳转到日记页面
     * @return
     */
    @RequestMapping("/diary")
    public String diaryPage(){
        return "lifeGame/diary";
    }

    /**
     * 修改plan状态
     * @return
     */
    @RequestMapping("/changeStatu")
    @ResponseBody
    public HashMap<String, Object> changeStatu(LifegameTempplan lifegameTempplan){
        return lifeGameTempPlanService.changeStatu(lifegameTempplan);
    }

    /**
     * 保存临时计划
     * @return
     */
    @RequestMapping("/saveTempPlan")
    @ResponseBody
    public HashMap<String, Object> saveTempPlan(HttpServletRequest request, String plan,String planCode,Integer planMoney,boolean isToday){
        LifegameTempplan lifegameTempplan = new LifegameTempplan();
        lifegameTempplan.setPlanName(plan);
        lifegameTempplan.setMoney(planMoney);
        //存储用户Code
        if(StringUtils.isNoneEmpty(planCode)){
            //设置plan的Code
            lifegameTempplan.setParentcode(planCode);
            lifegameTempplan.setType("0"); //类别：0长期 1固定 2临时
        }else {
            lifegameTempplan.setType("2");
        }
        if(!isToday){
            //逾期发起，金额-20
            lifeGameUserService.changeMoney(-10,"leekoko");
        }
        return lifeGameTempPlanService.save(lifegameTempplan,isToday);
    }

    /**
     * 获取今日选择的计划
     * @return
     */
    @RequestMapping("getTodayChosePlan")
    @ResponseBody
    public List<LifegameTempplan> getTodayChosePlan(HttpServletRequest request){
        return lifeGameTempPlanService.getTodayChosePlan();
    }

    /**
     * 获取今日已完成的计划
     * @return
     */
    @RequestMapping("getTodayOldPlan")
    @ResponseBody
    public List<LifegameTempplan> getTodayOldPlan(HttpServletRequest request){
        return lifeGameTempPlanService.getTodayOldPlan();
    }

    /**
     * 开始新一天的计划
     * @return
     */
    @RequestMapping("startNewDay")
    @ResponseBody
    public boolean startNewDay(HttpServletRequest request){
        //归档所有旧的计划，设置del_flag为1
        lifeGameTempPlanService.backUpOldPlan();
        //插入固定plan到临时计划表中
        lifeGameTempPlanService.insertNewPlan();
        //更新计划day +1
        lifeGameUserService.changePlanDay();
        return true;
    }



}
