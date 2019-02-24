package cn.leekoko.service.impl;

import cn.leekoko.mapper.TemplateMapper;
import cn.leekoko.pojo.Template;
import cn.leekoko.pojo.TemplateExample;
import cn.leekoko.service.TemplateService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    private TemplateMapper templateMapper;

    /**
     * 保存模板信息
     * @param template
     * @return 返回保存结果，保存的code
     */
    @Override
    public HashMap<String,Object> save(Template template) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        boolean flag = false;
        String templateCode = template.getCode();
        if(templateCode == ""){
            //新增
            String codeUuid = UUID.randomUUID().toString();

            template.setCode(codeUuid);
            template.setDelflag(0);
            template.setCreatedate(new Date().toString());
            template.setModifydate(new Date().toString());

            Integer insertNum = templateMapper.insert(template);


            if(insertNum > 0){
                flag = true;
                result.put("code",codeUuid);
            }
        }else{
            //更新
            template.setModifydate(new Date().toString());
            Integer updateNum = templateMapper.updateByPrimaryKeySelective(template);

            if(updateNum > 0){
                flag = true;
                result.put("code",templateCode);
            }
        }
        result.put("flag",flag);
        return result;
    }

    @Override
    public List<Template> getList() {
        TemplateExample example = new TemplateExample();
        example.setOrderByClause("modifyDate desc");
        List<Template> templateList = templateMapper.selectByExample(example);
        simplifySummary(templateList);
        return templateList;
    }

    /**
     * Simplified field for Summary,only get firt line
     * @param templateList
     * @return
     */
    private void simplifySummary(List<Template> templateList) {
        for (int i = 0; i < templateList.size(); i++) {
            Template temp = templateList.get(i);
            String summary = temp.getSummary();
            if(StringUtils.isNoneEmpty(summary)){
                summary = summary.split("\n\n")[0]; //only get first element
                temp.setSummary(summary);
            }
        }
    }

    @Override
    public Template getTemplateByCode(String code) {
        return templateMapper.selectByPrimaryKey(code);
    }

    /**
     * 删除模板
     * @param code
     * @return
     */
    @Override
    public boolean delete(String code) {
        boolean flag = false;
        int delNum = templateMapper.deleteByPrimaryKey(code);
        if(delNum > 0){
            flag = true;
        }
        return flag;
    }

}
