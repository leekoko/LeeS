package cn.leekoko.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;

@RequestMapping("/mobileColumn")
public class mobileColumnController {

    @RequestMapping("/save")
    public HashMap<String,Boolean> save(String id, String sql, String value){
        HashMap<String,Boolean> data = new HashMap<String,Boolean>();
        Boolean result = false;
        //保存到数据库
        data.put("result",result);
        return data;
    }

}
