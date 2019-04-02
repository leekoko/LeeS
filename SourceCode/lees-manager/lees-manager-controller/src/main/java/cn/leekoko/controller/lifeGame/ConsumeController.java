package cn.leekoko.controller.lifeGame;

import cn.leekoko.pojo.LifegameConsume;
import cn.leekoko.pojo.LifegameConsumeType;
import cn.leekoko.pojo.LifegameUser;
import cn.leekoko.service.ConsumeService;
import cn.leekoko.service.ConsumeTypeService;
import cn.leekoko.service.LifeGameUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/consume")
public class ConsumeController {

    @Autowired
    private ConsumeTypeService consumeTypeService;

    @Autowired
    private ConsumeService consumeService;

    @Autowired
    private LifeGameUserService lifeGameUserService;

    /**
     * 编辑计划页面
     * @param model
     * @return
     */
    @RequestMapping("/consumeType")
    public String editPlan(Model model ,HttpServletRequest request){
        model.addAttribute("typeList",consumeTypeService.findList());
        return "lifeGame/consumeType";
    }
    /**
     * 获取类别列表
     * @return
     */
    @RequestMapping("/getTypeList")
    @ResponseBody
    public List<LifegameConsumeType> getTypeList(HttpServletRequest request){
        return consumeTypeService.findList();
    }



    /**
     * 编辑计划页面
     * @param model
     * @return
     */
    @RequestMapping("/consumeRecord")
    public String consumeRecord(Model model, HttpServletRequest request){
        model.addAttribute("curMoney",lifeGameUserService.getCurMoney());
        return "lifeGame/consumeRecord";
    }

    /**
     * 保存type内容
     * @return
     */
    @RequestMapping("/saveType")
    @ResponseBody
    public HashMap<String, Object> saveType(LifegameConsumeType lifegameConsumeType){
        return consumeTypeService.save(lifegameConsumeType);
    }

    /**
     * 保存消费内容
     * @return
     */
    @RequestMapping("/saveConsume")
    @ResponseBody
    public boolean saveConsume(LifegameConsume lifegameConsume,HttpServletRequest request){
        //减去消费金额
        boolean flag = lifeGameUserService.changeMoney(-(lifegameConsume.getMoney()),"leekoko");
        if(flag){
            flag = consumeService.save(lifegameConsume);
        }
        return flag;
    }

    @RequestMapping("/delType")
    @ResponseBody
    public boolean delType(String code){
        return consumeTypeService.delType(code);
    }
}
