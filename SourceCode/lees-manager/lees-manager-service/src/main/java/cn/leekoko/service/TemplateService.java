package cn.leekoko.service;

import cn.leekoko.pojo.Template;

import java.util.HashMap;
import java.util.List;

public interface TemplateService {
    HashMap<String,Object> save(Template template);
    List<Template> getList();
    Template getTemplateByCode(String code);
}
