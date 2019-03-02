package cn.leekoko.controller.lifeGame;

import cn.leekoko.pojo.LifegameTempplan;
import cn.leekoko.service.LifeGameTempPlanService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/tempPlan")
public class TempPlanController {

    @Autowired
    private LifeGameTempPlanService lifeGameTempPlanService;

    /**
     * 计划列表页面
     * @param model
     * @return
     */
    @RequestMapping("/toDoList")
    public String toDoList(Model model){
        model.addAttribute("planList",lifeGameTempPlanService.getTodayAllPlan());
        return "lifeGame/toDoList";
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
    public HashMap<String, Object> saveTempPlan(String plan,String planCode,Integer planMoney){
        LifegameTempplan lifegameTempplan = new LifegameTempplan();
        lifegameTempplan.setPlanName(plan);
        lifegameTempplan.setMoney(planMoney);
        if(StringUtils.isNoneEmpty(planCode)){
            //设置plan的Code
            lifegameTempplan.setParentcode(planCode);
            lifegameTempplan.setType("0"); //类别：0长期 1固定 2临时
        }else {
            lifegameTempplan.setType("2");
        }
        return lifeGameTempPlanService.save(lifegameTempplan);
    }

    /**
     * 获取今日选择的计划
     * @return
     */
    @RequestMapping("getTodayChosePlan")
    @ResponseBody
    public List<LifegameTempplan> getTodayChosePlan(){
        return lifeGameTempPlanService.getTodayChosePlan();
    }

}
