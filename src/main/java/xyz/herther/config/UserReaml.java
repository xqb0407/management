package xyz.herther.config;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import xyz.herther.pojo.TbAdmin;
import xyz.herther.service.LoginService;

/**
 * @Herther
 * UserReaml类
 * 2020.7.12
 */

public class UserReaml extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("配置资源");
        return null;
    }

    @Autowired
    private LoginService loginService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg) throws AuthenticationException {
        System.out.println("UserReaml层");
        UsernamePasswordToken token =(UsernamePasswordToken)arg;
        System.out.println("用户密码："+token.getUsername()+"，"+token.getPassword());
        char[] c = token.getPassword();
        System.out.println("tonken:"+c);
        String md5password =String.valueOf(new char[]{'c'});
        System.out.println("md5:"+md5password);
        String password = DigestUtils.md5DigestAsHex(md5password.getBytes());
        TbAdmin tbAdmin = loginService.login(token.getUsername(), password);
        if (tbAdmin==null){
            return null;
        }
        return new SimpleAuthenticationInfo(tbAdmin,tbAdmin.getPassword(),"");
    }
}
