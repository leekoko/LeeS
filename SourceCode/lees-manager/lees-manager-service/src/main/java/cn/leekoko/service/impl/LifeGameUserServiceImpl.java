package cn.leekoko.service.impl;

import cn.leekoko.common.utils.DateUtil;
import cn.leekoko.mapper.LifegameUserMapper;
import cn.leekoko.pojo.LifegameUser;
import cn.leekoko.pojo.LifegameUserExample;
import cn.leekoko.service.LifeGameUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LifeGameUserServiceImpl implements LifeGameUserService {

    @Autowired
    private LifegameUserMapper lifegameUserMapper;

    /**
     * 获取指定账号用户
     * @param userName
     * @return
     */
    @Override
    public LifegameUser get(String userName) {
        LifegameUserExample example = new LifegameUserExample();
        LifegameUserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(userName);
        List<LifegameUser> users = lifegameUserMapper.selectByExample(example);
        LifegameUser user = null;
        if(users.size() > 0){
            user = users.get(0);
        }
        return user;
    }

    /**
     * 计划日期添加一天
     * @return
     */
    @Override
    public boolean changePlanDay(String userName) {
        boolean flag = false;
        LifegameUser user = this.get(userName);
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
    public Integer getCurMoney(String userName) {
        LifegameUser user = this.get(userName);
        return user.getAllMoney();
    }

    /**
     * 改变金额数值
     * @param changeNum 改变值
     * @return
     */
    @Override
    public boolean changeMoney(Integer changeNum, String userName){
        boolean flag = false;
        LifegameUser user = this.get(userName);
        Integer curMoney = user.getAllMoney();
        curMoney = curMoney + changeNum;
        user.setAllMoney(curMoney);
        int inNum = lifegameUserMapper.updateByPrimaryKey(user);
        if(inNum > 0){
            flag = true;
        }
        return flag;
    }

    /**
     * 用户检查登录
     * @param lifegameUser
     * @return
     */
    @Override
    public boolean checkLogin(LifegameUser lifegameUser) {
        boolean flag = false;
        LifegameUser user = this.get(lifegameUser.getUserName());
        if(user != null && lifegameUser.getTsm1().equals(user.getTsm1())){
            //判断密码正确
            lifegameUser.setCode(user.getCode());
            flag = true;
        }
        return flag;
    }


}
