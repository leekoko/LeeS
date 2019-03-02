package cn.leekoko.service.impl;

import cn.leekoko.common.utils.DateUtil;
import cn.leekoko.mapper.LifegameTempplanMapper;
import cn.leekoko.pojo.LifegamePlan;
import cn.leekoko.pojo.LifegameTempplan;
import cn.leekoko.pojo.LifegameTempplanExample;
import cn.leekoko.service.LifeGameTempPlanService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class LifeGameTempPlanServiceImpl implements LifeGameTempPlanService {

    @Autowired
    private LifegameTempplanMapper lifegameTempPlanMapper;

    @Override
    public HashMap<String, Object> save(LifegameTempplan lifegameTempplan) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        boolean flag = false;
        String code = lifegameTempplan.getCode();
        if(code == "" || code == null){
            String codeUuid = UUID.randomUUID().toString();

            lifegameTempplan.setCode(codeUuid);
            lifegameTempplan.setDelflag(0);
            lifegameTempplan.setFinish("0"); //完成标志 0未完成 1已完成
            lifegameTempplan.setCreatedate(DateUtil.getDateTime());
            lifegameTempplan.setModifydate(DateUtil.getDateTime());
            //设定执行时间   （加1天，测试时不加）
            lifegameTempplan.setTsm1(DateUtil.getDate());

            Integer insertNum = lifegameTempPlanMapper.insert(lifegameTempplan);

            if(insertNum > 0){
                flag = true;
            }
        }
        result.put("flag",flag);
        return result;
    }

    /**
     * 获取今日所有计划
     * @return
     */
    @Override
    public List<LifegameTempplan> getTodayAllPlan() {
        LifegameTempplanExample example = new LifegameTempplanExample();
        LifegameTempplanExample.Criteria criteria = example.createCriteria();
        criteria.andTsm1EqualTo(DateUtil.getDate());
        return lifegameTempPlanMapper.selectByExample(example);
    }

    /**
     * 获取今日所有选择的计划
     * @return
     */
    @Override
    public List<LifegameTempplan> getTodayChosePlan() {
        LifegameTempplanExample example = new LifegameTempplanExample();
        LifegameTempplanExample.Criteria criteria = example.createCriteria();
        criteria.andTsm1EqualTo(DateUtil.getDate());
        criteria.andTypeEqualTo("0");
        return lifegameTempPlanMapper.selectByExample(example);
    }


    @Override
    public HashMap<String, Object> changeStatu(LifegameTempplan lifegameTempplan) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        boolean flag = false;
        //更新
        lifegameTempplan.setModifydate(DateUtil.getDateTime());
        lifegameTempplan.setFinish("1");
        Integer updateNum = lifegameTempPlanMapper.updateByPrimaryKeySelective(lifegameTempplan);

        if(updateNum > 0){
            flag = true;
        }
        result.put("flag",flag);
        return result;
    }

}
