package cn.leekoko.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mobile")
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

    /**
     * 主界面
     */
    @RequestMapping("/mainFrame")
    public String mainFrame(){
        return "/mobile/mainFrame";
    }
    /**
     * 首页
     */
    @RequestMapping("/mainPage")
    public String mainPage(){
        return "/mobile/mainPage";
    }

    /**
     * 后台管理页面
     * @return
     */
    @RequestMapping("/backStagePage")
    public String backStagePage(){
        return "/mobile/backStagePage";
    }
}
