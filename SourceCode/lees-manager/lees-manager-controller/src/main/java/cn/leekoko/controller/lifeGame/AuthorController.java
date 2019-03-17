package cn.leekoko.controller.lifeGame;

import cn.leekoko.pojo.LifegameUser;
import cn.leekoko.service.LifeGameUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private LifeGameUserService lifeGameUserService;

    /**
     * 登录页面
     * @return
     */
    @RequestMapping("/loginPage")
    public String loginPage(){
        return "lifeGame/loginPage";
    }

    /**
     * 检查用户登录
     * @param lifegameUser
     * @return
     */
    @RequestMapping("/loginUser")
    public ModelAndView loginUser(LifegameUser lifegameUser, HttpSession session, ModelAndView mv){
        if(lifeGameUserService.checkLogin(lifegameUser)){
            lifegameUser.setTsm1("");
            session.setAttribute("user",lifegameUser);
            mv.setViewName("lifeGame/lifeGameIndex");
        }else{
            mv.addObject("message","账号密码错误，请重新输入");
            mv.setViewName("author/loginPage");
        }
        return mv;
    }

}
