package cn.leekoko.controller.lifeGame;

import cn.leekoko.pojo.LifegameUser;
import cn.leekoko.service.LifeGameUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * 登陆逻辑   暂时弃用
 */
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
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(lifegameUser.getUserName(),lifegameUser.getTsm1());
        try{
            subject.login(token);
        }catch (AuthenticationException e){
            e.getMessage();
            mv.setViewName("lifeGame/loginPage");
        }
        mv.setViewName("lifeGame/lifeGameIndex");
        return mv;
    }

}
