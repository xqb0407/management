package xyz.herther.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;

import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.herther.tools.Result;
import xyz.herther.tools.ResultUtil;

import javax.servlet.http.HttpServletRequest;


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
    @ResponseBody
    public ResultUtil LoginManager(HttpServletRequest request, String username , String password){
        System.out.println("控制层");
        System.out.println("用户名："+username+"密码："+password);
        String password1 = DigestUtils.md5DigestAsHex(password.getBytes());
        /**
         * shiro逻辑
         */
        try {
            Subject subject = SecurityUtils.getSubject();
            // 封装用户密码
            UsernamePasswordToken token = new UsernamePasswordToken(username,password1);
            //执行登录方法
            subject.login(token);
        } catch (UnknownAccountException e) {
            return ResultUtil.error(e.getMessage());
        }catch (IncorrectCredentialsException e){
            return ResultUtil.error(e.getMessage());
        }catch (LockedAccountException e) {
            return ResultUtil.error(e.getMessage());
        }catch (AuthenticationException e){
            return ResultUtil.error("账户验证失败");
        }
        return ResultUtil.ok();
    }

}
