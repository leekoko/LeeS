package cn.leekoko.service.impl;

import cn.leekoko.mapper.TemplateMapper;
import cn.leekoko.mapper.TemplateflowMapper;
import cn.leekoko.pojo.Template;
import cn.leekoko.pojo.TemplateExample;
import cn.leekoko.pojo.Templateflow;
import cn.leekoko.pojo.TemplateflowExample;
import cn.leekoko.service.TemplateFlowService;
import cn.leekoko.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class TemplateFlowServiceImpl implements TemplateFlowService {

    @Autowired
    private TemplateflowMapper templateflowMapper;

    /**
     * 保存模板流程信息
     * @param templateflow
     * @return
     */
    @Override
    public boolean save(Templateflow templateflow) {
        boolean flag = false;
        //新增
        String codeUuid = UUID.randomUUID().toString();

        templateflow.setCode(codeUuid);
        templateflow.setDelflag(0);
        templateflow.setCreatedate(new Date().toString());
        templateflow.setModifydate(new Date().toString());

        Integer insertNum = templateflowMapper.insert(templateflow);

        if(insertNum > 0){
            flag = true;
        }
        return flag;
    }

    @Override
    public List<Templateflow> getList() {
        TemplateflowExample example = new TemplateflowExample();
        example.setOrderByClause("modifyDate desc");
        return templateflowMapper.selectByExample(example);
    }

    @Override
    public boolean delete(String code) {
        boolean flag = false;
        int delNum = templateflowMapper.deleteByPrimaryKey(code);
        if(delNum > 0){
            flag = true;
        }
        return flag;
    }
}
