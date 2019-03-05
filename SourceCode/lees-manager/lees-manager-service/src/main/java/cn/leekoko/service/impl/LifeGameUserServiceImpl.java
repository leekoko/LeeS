package cn.leekoko.service.impl;

import cn.leekoko.common.utils.DateUtil;
import cn.leekoko.mapper.LifegameUserMapper;
import cn.leekoko.pojo.LifegameUser;
import cn.leekoko.pojo.LifegameUserExample;
import cn.leekoko.service.LifeGameUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LifeGameUserServiceImpl implements LifeGameUserService {

    @Autowired
    private LifegameUserMapper lifegameUserMapper;

    @Override
    public LifegameUser get() {
        LifegameUserExample example = new LifegameUserExample();
        LifegameUserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo("leekoko");
        return lifegameUserMapper.selectByExample(example).get(0);
    }

    /**
     * 计划日期添加一天
     * @return
     */
    @Override
    public boolean changePlanDay() {
        boolean flag = false;
        LifegameUser user = this.get();
        String newDate = DateUtil.addOneDay(user.getPlanDay());
        user.setPlanDay(newDate);
        int inNum = lifegameUserMapper.updateByPrimaryKey(user);
        if(inNum > 0){
            flag = true;
        }
        return flag;
    }

    /**
     * 获取当前总金额
     * @return
     */
    @Override
    public Integer getCurMoney() {
        LifegameUser user = this.get();
        return user.getAllMoney();
    }

    /**
     * 改变金额数值
     * @param changeNum 改变值
     * @return
     */
    @Override
    public boolean changeMoney(Integer changeNum){
        boolean flag = false;
        LifegameUser user = this.get();
        Integer curMoney = user.getAllMoney();
        curMoney = curMoney + changeNum;
        user.setAllMoney(curMoney);
        int inNum = lifegameUserMapper.updateByPrimaryKey(user);
        if(inNum > 0){
            flag = true;
        }
        return flag;
    }



}
