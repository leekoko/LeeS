package cn.leekoko.controller.lifeGame;


import cn.leekoko.pojo.LifegameConsume;
import cn.leekoko.service.ConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("/consume")
public class ConsumeController {

    @Autowired
    private ConsumeService consumeService;

    /**
     * 编辑计划页面
     * @param model
     * @return
     */
    @RequestMapping("/consumeType")
    public String editPlan(Model model){
//        model.addAttribute("typeList",lifeGamePlanService.findList("1"));
        return "lifeGame/consumeType";
    }

    /**
     * 保存type内容
     * @return
     */
    @RequestMapping("/saveType")
    @ResponseBody
    public HashMap<String, Object> saveType(LifegameConsume lifegameConsume){
        return consumeService.save(lifegameConsume);
    }
}
