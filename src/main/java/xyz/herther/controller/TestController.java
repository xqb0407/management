package xyz.herther.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


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
}
