package xyz.herther.config;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import xyz.herther.mapper.TbAdminMapper;
import xyz.herther.pojo.TbAdmin;
import xyz.herther.pojo.TbAdminExample;
import xyz.herther.service.LoginService;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

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

    @Resource
    private TbAdminMapper tbAdminMapper;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg) throws AuthenticationException {
        System.out.println("UserReaml层");
        //把token携带的用户名密码解析出来
        UsernamePasswordToken token =(UsernamePasswordToken)arg;
        String username = token.getUsername();
        String password = new String((char[]) token.getPassword());
        //把用户名带入数据库查找语句
        TbAdminExample example = new TbAdminExample();
        TbAdminExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<TbAdmin> tbAdmins = tbAdminMapper.selectByExample(example);
        System.out.println("数据库查询出："+ tbAdmins.toString());
        //验证用户名
        if (tbAdmins==null || tbAdmins.size() == 0){
            throw new UnknownAccountException("账号不存在!");

        }

        System.out.println("数据库拿出来的密码："+tbAdmins.get(0).getPassword());
        //验证密码
        if (!password.equals(tbAdmins.get(0).getPassword())){
            throw new IncorrectCredentialsException("账号或密码不正确!");
        }

        if (tbAdmins.get(0).getRoleId()==null || tbAdmins.get(0).getRoleId() ==0){
            throw  new UnknownAccountException("账号未分配角色!");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(tbAdmins.get(0), password, getName());
        return info;
    }
}
