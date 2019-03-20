package cn.leekoko.service.impl;

import cn.leekoko.mapper.LifegameConsumeTypeMapper;
import cn.leekoko.pojo.LifegameConsumeType;
import cn.leekoko.pojo.LifegameConsumeTypeExample;
import cn.leekoko.service.ConsumeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class ConsumeTypeServiceImpl implements ConsumeTypeService {

    @Autowired
    private LifegameConsumeTypeMapper lifegameConsumeTypeMapper;


    @Override
    public HashMap<String, Object> save(LifegameConsumeType lifegameConsumeType) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        boolean flag = false;
        String code = lifegameConsumeType.getCode();
        if(code == "" || code == null){
            //新增
            String codeUuid = UUID.randomUUID().toString();

            lifegameConsumeType.setCode(codeUuid);
            lifegameConsumeType.setDelflag(0);
            lifegameConsumeType.setCreatedate(new Date().toString());
            lifegameConsumeType.setModifydate(new Date().toString());

            Integer insertNum = lifegameConsumeTypeMapper.insert(lifegameConsumeType);

            if(insertNum > 0){
                flag = true;
                result.put("code",codeUuid);
            }
        }
        result.put("flag",flag);
        return result;
    }

    @Override
    public List<LifegameConsumeType> findList(String userCode) {
        LifegameConsumeTypeExample example = new LifegameConsumeTypeExample();
        LifegameConsumeTypeExample.Criteria criteria = example.createCriteria();
        criteria.andTsm2EqualTo(userCode);
        return lifegameConsumeTypeMapper.selectByExample(example);
    }

    @Override
    public boolean delType(String code) {
        boolean flag = false;
        int delNum = lifegameConsumeTypeMapper.deleteByPrimaryKey(code);
        if(delNum > 0){
            flag = true;
        }
        return flag;
    }
}
