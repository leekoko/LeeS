package cn.leekoko.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MobilePageController {

    /**
     * 打开首页
     */
    @RequestMapping("/login")
    public String showLogin(){
        return "/mobile/login";
    }

    /**
     * 打开拍照页面
     * @return
     */
    @RequestMapping("/camera")
    public String showCamera(){
        return "/mobile/camera";
    }

}
