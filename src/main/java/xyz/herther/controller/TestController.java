package xyz.herther.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.herther.tools.ResultUtil;


@Controller
public class TestController {

    @RequestMapping("/hello")
    @ResponseBody
    public String TestController(){
        return "测试信息";
    }

//    @RequestMapping("/")
//    public String login(){
//        return "/login";
//    }
    @RequestMapping("/app")
    @ResponseBody
    public ResultUtil applicationBeat(String username ,String password){
        System.out.println("username:"+username+"password:"+password);
        return ResultUtil.ok();

    }
    @RequestMapping("/index")
    public String GoIndex(){
        return "/index";
    }
    @RequestMapping("/{page}")
    public String path(@PathVariable String page){
        return page;
    }
}
