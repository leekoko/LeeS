package cn.leekoko.service.impl;

import cn.leekoko.common.utils.DateUtil;
import cn.leekoko.mapper.LifegamePlanMapper;
import cn.leekoko.mapper.LifegameTempplanMapper;
import cn.leekoko.mapper.LifegameUserMapper;
import cn.leekoko.pojo.*;
import cn.leekoko.service.LifeGameTempPlanService;
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
    @Autowired
    private LifegameUserMapper lifegameUserMapper;

    @Override
    public HashMap<String, Object> save(LifegameTempplan lifegameTempplan, boolean isToday) {
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
            if(isToday){
                lifegameTempplan.setTsm1(DateUtil.addOneDay(DateUtil.getDate()));
            }else {
                lifegameTempplan.setTsm1(DateUtil.getDate());
            }
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
        //回显只显示明天执行的计划
        criteria.andTsm1EqualTo(DateUtil.addOneDay(DateUtil.getDate()));
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
        criteria.andTsm1EqualTo(DateUtil.reduceOneDay(DateUtil.getDate()) );
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
            lifegameTempplan.setTsm1(DateUtil.getDate());
            this.save(lifegameTempplan,false); //引入固定计划是当天计划，计划开始时间无需+1
        }
        return true;
    }


    @Override
    public HashMap<String, Object> changeStatu(LifegameTempplan lifegameTempplan) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        boolean flag = false;
        //更新状态
        lifegameTempplan.setModifydate(DateUtil.getDateTime());
        Integer updateNum = lifegameTempPlanMapper.updateByPrimaryKeySelective(lifegameTempplan);
        //更新金额
        changeUserMoney(lifegameTempplan.getFinish(),lifegameTempplan.getMoney());
        if(updateNum > 0){
            flag = true;
        }
        result.put("flag",flag);
        return result;
    }

    private boolean changeUserMoney(String changeType,Integer planMoney) {
        boolean flag = false;
        LifegameUserExample example = new LifegameUserExample();
        LifegameUserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo("leekoko");
        LifegameUser user = lifegameUserMapper.selectByExample(example).get(0);
        Integer money = user.getAllMoney();
        if(changeType.equals("1")){
            money = money + planMoney;
        }else{
            money = money - planMoney;
        }
        user.setAllMoney(money);
        int inNum = lifegameUserMapper.updateByPrimaryKey(user);
        if(inNum > 0){
            flag = true;
        }
        return flag;
    }

}
