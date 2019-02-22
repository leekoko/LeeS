package cn.leekoko.controller;

import cn.leekoko.pojo.Templateflow;
import cn.leekoko.service.TemplateFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/templateFlow")
public class TemplateFlowController {
    @Autowired
    private TemplateFlowService templateFlowService;

    @RequestMapping("/saveFlow")
    @ResponseBody
    public boolean saveFlow(Templateflow templateflow){
        return templateFlowService.save(templateflow);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public boolean delete(String code){
        return templateFlowService.delete(code);
    }


}
