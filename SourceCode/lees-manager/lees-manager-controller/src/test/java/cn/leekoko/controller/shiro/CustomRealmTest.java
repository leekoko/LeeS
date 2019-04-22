package cn.leekoko.controller.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class CustomRealmTest {

    @Test
    public void testAuth(){
        CustomRealm customRealm = new CustomRealm();
        //构建SecurityManager
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        //md5加密
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5");
        matcher.setHashIterations(1); //hash迭代次数
        customRealm.setCredentialsMatcher(matcher);

        defaultSecurityManager.setRealm(customRealm);

        //主题提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("leekoko","123456");
        subject.login(token);
        //登陆校验
        System.out.println("isAuthenticated:"+subject.isAuthenticated());
        //权限校验
        subject.checkRole("admin");
        subject.checkPermissions("user:add","user:delete");
    }

    @Test
    public void testJunit(){
        Md5Hash mad5Hash = new Md5Hash("123456","leekoko");
        System.out.println(mad5Hash.toString());
    }
}