package cn.leekoko.controller;

import cn.leekoko.pojo.Template;
import cn.leekoko.service.TemplateService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("/template")
public class TemplateController {
    @Autowired
    private TemplateService templateService;

    @RequestMapping("/save")
    @ResponseBody
    public HashMap<String,Object> save(Template template){
        return templateService.save(template);
    }

    @RequestMapping("/getContentByCode")
    @ResponseBody
    public HashMap<String,Object> getContentByCode(@Param("code") String code){
        boolean flag = false;
        HashMap<String,Object> map = new HashMap<String, Object>();
        Template template = templateService.getTemplateByCode(code);
        if(template != null){
            map.put("title",template.getTitle());
            map.put("summary",template.getSummary());
            map.put("content",template.getContent());
            map.put("code",template.getCode());
            flag = true;
        }
        map.put("flag",flag);
        return map;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public boolean delete(String code){
        return templateService.delete(code);
    }
}
