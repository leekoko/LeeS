package cn.leekoko.service.impl;

import cn.leekoko.mapper.LifegameTempplanMapper;
import cn.leekoko.mapper.LifegameUserMapper;
import cn.leekoko.pojo.LifegameUser;
import cn.leekoko.pojo.LifegameUserExample;
import cn.leekoko.service.LifeGameUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
        String newDate = this.reduceOneDay(user.getPlanDay());
        user.setPlanDay(newDate);
        int inNum = lifegameUserMapper.updateByPrimaryKey(user);
        if(inNum > 0){
            flag = true;
        }
        return flag;
    }

    /**
     * 当前日期加上一天
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
        calendar.add(Calendar.DATE, 1);
        return sj.format(calendar.getTime());
    }


}
