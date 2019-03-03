package cn.leekoko.service.impl;

import cn.leekoko.common.utils.DateUtil;
import cn.leekoko.mapper.LifegamePlanMapper;
import cn.leekoko.mapper.LifegameTempplanMapper;
import cn.leekoko.pojo.LifegamePlan;
import cn.leekoko.pojo.LifegamePlanExample;
import cn.leekoko.pojo.LifegameTempplan;
import cn.leekoko.pojo.LifegameTempplanExample;
import cn.leekoko.service.LifeGameTempPlanService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class LifeGameTempPlanServiceImpl implements LifeGameTempPlanService {

    @Autowired
    private LifegameTempplanMapper lifegameTempPlanMapper;
    @Autowired
    private LifegamePlanMapper lifegamePlanMapper;

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

    /**
     * 备份旧计划
     * @return
     */
    @Override
    public boolean backUpOldPlan() {
        //获取昨天的任务列表
        LifegameTempplanExample example = new LifegameTempplanExample();
        LifegameTempplanExample.Criteria criteria = example.createCriteria();
        criteria.andTsm1EqualTo(reduceOneDay(DateUtil.getDate()) );
        List<LifegameTempplan> list = lifegameTempPlanMapper.selectByExample(example);
        //设置del_flag为1表明备份状态
        for (int i = 0; i < list.size(); i++) {
            LifegameTempplan temp = list.get(i);
            temp.setDelflag(1);
            lifegameTempPlanMapper.updateByPrimaryKey(temp);
        }
        return true;
    }

    /**
     * 插入固定计划到临时计划表中
     * @return
     */
    @Override
    public boolean insertNewPlan() {
        LifegamePlanExample example = new LifegamePlanExample();
        LifegamePlanExample.Criteria criteria = example.createCriteria();
        criteria.andTypeEqualTo("1"); //类别0长期 1固定 2临时
        List<LifegamePlan> list = lifegamePlanMapper.selectByExample(example);
        for (int i = 0; i < list.size(); i++) {
            LifegamePlan lifegamePlan = list.get(i);
            //保存到临时计划表
            LifegameTempplan lifegameTempplan = new LifegameTempplan();
            lifegameTempplan.setPlanName(lifegamePlan.getPlanName());
            lifegameTempplan.setMoney(lifegamePlan.getMoney());
            lifegameTempplan.setParentcode(lifegamePlan.getCode());
            lifegameTempplan.setType("1");
            this.save(lifegameTempplan);
        }
        return true;
    }

    /**
     * 当前日期减去一天
     * @throws ParseException
     */
    private String reduceOneDay(String today){
        SimpleDateFormat sj = new SimpleDateFormat("yyyy-MM-dd");
        Date d = null;
        try {
            d = sj.parse(today);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.DATE, -1);
        return sj.format(calendar.getTime());
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
