package cn.leekoko.controller.lifeGame;

import cn.leekoko.pojo.LifegamePlan;
import cn.leekoko.pojo.LifegameUser;
import cn.leekoko.service.LifeGamePlanService;
import cn.leekoko.service.LifeGameUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
@RequestMapping("/lifeGame")
public class LifeGameController {

    @Autowired
    private LifeGamePlanService lifeGamePlanService;

    @Autowired
    private LifeGameUserService lifeGameUserService;

    /**
     * 跳转到LifeGame首页
     * @return
     */
    @RequestMapping("/lifeGameIndex")
    public String lifeGameIndexPage(Model model, HttpServletRequest request){
        LifegameUser user = (LifegameUser) request.getSession().getAttribute("user");
        model.addAttribute("curMoney",lifeGameUserService.getCurMoney(user.getUserName()));
        return "lifeGame/lifeGameIndex";
    }

    @RequestMapping("/chosePlan")
    public String chosePlan(Model model){
        model.addAttribute("planList",lifeGamePlanService.findList("0")); //长期类别
        return "lifeGame/chosePlan";
    }


    /**
     * 编辑计划页面
     * @param model
     * @return
     */
    @RequestMapping("/editPlan")
    public String editPlan(Model model){
        model.addAttribute("planList",lifeGamePlanService.findList("0")); //长期类别
        model.addAttribute("planList2",lifeGamePlanService.findList("1")); //固定类别
        return "lifeGame/editPlan";
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

}
