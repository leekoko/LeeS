package cn.leekoko.controller.lifeGame;

import cn.leekoko.pojo.LifegameUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限控制
 */
public class AuthorizationInterceptor implements HandlerInterceptor {
    //或略拦截页面
    private static final String[] IGNORE_URI = {"author/loginPage","author/loginUser"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        boolean flag = false;
        //请求路径进行判断
        String servletPath = request.getServletPath();
        for (String s : IGNORE_URI) {
            if(servletPath.contains(s)){
                flag = true;
                break;
            }
        }
        if(!flag){
            //登录
            LifegameUser user = (LifegameUser) request.getSession().getAttribute("user");
            //判断用户是否登录过
            if(user == null){
                System.out.println("拦截请求");
                request.setAttribute("message","请先登录网站");
                request.getRequestDispatcher("author/loginPage").forward(request,response);
            }else{
                System.out.println("请求放行");
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("登录成功");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
