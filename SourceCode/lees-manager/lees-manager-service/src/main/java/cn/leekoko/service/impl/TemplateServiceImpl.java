package cn.leekoko.service.impl;

import cn.leekoko.mapper.TemplateMapper;
import cn.leekoko.pojo.Template;
import cn.leekoko.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    private TemplateMapper templateMapper;

    @Override
    public Integer save(Template template) {
        template.setCode(UUID.randomUUID().toString());
        template.setDelflag(0);
        template.setCreatedate(new Date().toString());
        template.setModifydate(new Date().toString());
        return templateMapper.insert(template);
    }
}
