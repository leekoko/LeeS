package cn.leekoko.controller.lifeGame;

import cn.leekoko.pojo.LifegamePlan;
import cn.leekoko.service.LifeGamePlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("/lifeGame")
public class LifeGameController {

    @Autowired
    private LifeGamePlanService lifeGamePlanService;

    /**
     * 跳转到LifeGame首页
     * @return
     */
    @RequestMapping("/lifeGameIndex")
    public String lifeGameIndexPage(Model model){
        return "lifeGame/lifeGameIndex";
    }

    /**
     * 跳转到日记页面
     * @return
     */
    @RequestMapping("/diary")
    public String diaryPage(Model model){
        return "lifeGame/diary";
    }

    /**
     * 编辑计划页面
     * @param model
     * @return
     */
    @RequestMapping("/editPlan")
    public String editPlan(Model model){
        model.addAttribute("planList",lifeGamePlanService.findList());
        return "lifeGame/editPlan";
    }

    /**
     * 计划列表页面
     * @param model
     * @return
     */
    @RequestMapping("/toDoList")
    public String toDoList(Model model){
        model.addAttribute("planList",lifeGamePlanService.findList());
        return "lifeGame/toDoList";
    }

    /**
     * 保存plan内容
     * @return
     */
    @RequestMapping("/savePlan")
    @ResponseBody
    public HashMap<String, Object> savePlan(LifegamePlan lifegamePlan){
        return lifeGamePlanService.save(lifegamePlan);
    }

    /**
     * 删除plan内容
     * @return
     */
    @RequestMapping("/delPlan")
    @ResponseBody
    public HashMap<String, Object> delPlan(String code){
        return lifeGamePlanService.delete(code);
    }

    /**
     * 修改plan状态
     * @return
     */
    @RequestMapping("/changeStatu")
    @ResponseBody
    public HashMap<String, Object> changeStatu(LifegamePlan lifegamePlan){
        return lifeGamePlanService.changeStatu(lifegamePlan);
    }

}
