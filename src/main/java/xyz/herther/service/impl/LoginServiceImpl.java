package xyz.herther.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import xyz.herther.mapper.TbAdminMapper;
import xyz.herther.pojo.TbAdmin;
import xyz.herther.pojo.TbAdminExample;
import xyz.herther.service.LoginService;

import javax.annotation.Resource;
import java.util.List;

public class LoginServiceImpl implements LoginService {

   @Resource
   private TbAdminMapper tbAdminMapper;


    @Override
    public TbAdmin login(String username,String password) {
       return null;
    }
}
