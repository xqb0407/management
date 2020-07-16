package xyz.herther.service;

import xyz.herther.pojo.TbAdmin;


public interface LoginService {
    TbAdmin login(String username,String password);   //登录接口
}
