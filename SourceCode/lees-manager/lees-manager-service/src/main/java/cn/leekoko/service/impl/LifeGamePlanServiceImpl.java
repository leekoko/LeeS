package cn.leekoko.service.impl;

import cn.leekoko.common.utils.DateUtil;
import cn.leekoko.mapper.LifegamePlanMapper;
import cn.leekoko.pojo.LifegamePlan;
import cn.leekoko.pojo.LifegamePlanExample;
import cn.leekoko.service.LifeGamePlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class LifeGamePlanServiceImpl implements LifeGamePlanService {

    @Autowired
    private LifegamePlanMapper lifegamePlanMapper;

    @Override
    public HashMap<String, Object> save(LifegamePlan lifegamePlan) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        boolean flag = false;
        String code = lifegamePlan.getCode();
        if(code == "" || code == null){
            //新增
            String codeUuid = UUID.randomUUID().toString();

            lifegamePlan.setCode(codeUuid);
            lifegamePlan.setDelflag(0);
            lifegamePlan.setCreatedate(DateUtil.getDateTime());
            lifegamePlan.setModifydate(DateUtil.getDateTime());

            Integer insertNum = lifegamePlanMapper.insert(lifegamePlan);

            if(insertNum > 0){
                flag = true;
                result.put("code",codeUuid);
            }
        }
        result.put("flag",flag);
        return result;
    }

    @Override
    public List<LifegamePlan> findList(String type) {
        LifegamePlanExample example = new LifegamePlanExample();
        LifegamePlanExample.Criteria criteria = example.createCriteria();
        criteria.andTypeEqualTo(type);
        return lifegamePlanMapper.selectByExample(example);
    }

    @Override
    public HashMap<String, Object> delete(String code) {
        boolean flag = false;
        Integer delNum = lifegamePlanMapper.deleteByPrimaryKey(code);
        if(delNum > 0){
            flag = true;
        }
        HashMap<String,Object> result = new HashMap<String,Object>();
        result.put("flag",flag);
        return result;
    }

}
