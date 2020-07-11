package xyz.herther.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @Herther
 * 登录逻辑Conrtoller
 * 2020.7.4
 */
@Controller
public class LoginController {




    @RequestMapping("/tologin")
    public String tologin(){
        return "/login";
    }

    /**
     * 登录Shiro
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/LoginManager")
    public String LoginManager(String username ,String password){
        System.out.println("控制层");
        System.out.println("用户名："+username+"密码："+password);
        /**
         * shiro逻辑
         */
        Subject subject = SecurityUtils.getSubject();
//        封装用户密码
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        //执行登录方法
        try {
            subject.login(token);
            return "/index";
        } catch (UnknownAccountException e) {
            return "/login";
        }catch (IncorrectCredentialsException e){
            return "/login";
        }
    }
}
