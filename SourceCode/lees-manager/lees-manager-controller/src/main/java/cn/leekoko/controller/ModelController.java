package cn.leekoko.controller;

import cn.leekoko.pojo.Template;
import cn.leekoko.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/modelController")
public class ModelController {
    @Autowired
    private TemplateService templateService;

    @RequestMapping("/save")
    @ResponseBody
    public boolean save(Template template){
        boolean result = false;
        Integer num = templateService.save(template);
        if(num > 0){
            result = true;
        }
        return result;
    }


}
