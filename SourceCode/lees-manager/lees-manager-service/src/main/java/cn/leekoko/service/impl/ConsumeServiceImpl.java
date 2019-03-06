package cn.leekoko.service.impl;

import cn.leekoko.mapper.LifegameConsumeMapper;
import cn.leekoko.pojo.LifegameConsume;
import cn.leekoko.service.ConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

@Service
public class ConsumeServiceImpl implements ConsumeService {

    @Autowired
    private LifegameConsumeMapper lifegameConsumeMapper;


    @Override
    public boolean save(LifegameConsume lifegameConsume) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        boolean flag = false;
        String code = lifegameConsume.getCode();
        if(code == "" || code == null){
            //新增
            String codeUuid = UUID.randomUUID().toString();

            lifegameConsume.setCode(codeUuid);
            lifegameConsume.setDelflag(0);
            lifegameConsume.setCreatedate(new Date().toString());
            lifegameConsume.setModifydate(new Date().toString());

            Integer insertNum = lifegameConsumeMapper.insert(lifegameConsume);

            if(insertNum > 0){
                flag = true;
                result.put("code",codeUuid);
            }
        }
        return flag;
    }

}
