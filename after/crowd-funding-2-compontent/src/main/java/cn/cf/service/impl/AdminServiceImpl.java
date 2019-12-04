package cn.cf.service.impl;

import cn.cf.entity.Admin;
import cn.cf.entity.AdminExample;
import cn.cf.mapper.AdminMapper;
import cn.cf.service.AdminService;
import cn.cf.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author ：ZWQ
 * @version ：1.0
 * @date ：2019/11/30 - 16:44
 * @description ：
 */
@Service
public class AdminServiceImpl implements AdminService {

   //@Autowired
   // private AdminMapper adminMapper;    依赖注入不推荐使用变量注入
    private AdminMapper adminMapper;
    @Autowired
    public void setLoginService (AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    /**
     * 获取所有用户
     * @return
     */
    public List<Admin> getAll() {
        return adminMapper.selectByExample(new AdminExample());
    }

    /**
     * 测试方法--事务
     */
    public void updateAdmin() {

        adminMapper.updateByPrimaryKey(new Admin(1,"123123","哈利修改","harry","harry@qq.com",null));
        System.out.println("测试事务的执行");
       // System.out.println(10/0);
        adminMapper.updateByPrimaryKey(new Admin(2,"1231456","波比修改","body","body@qq.com",null));

    }

    public Admin login(String loginAcct, String userPswd) {

        //根据用户名查询数据库
        AdminExample example = new AdminExample();
        example.createCriteria().andLoginAcctEqualTo(loginAcct);
        List<Admin> admins = adminMapper.selectByExample(example);
        //判断用户集合是否有效
        if(Md5Util.collectiveEffective(admins)){
            //账号唯一，只能查出一条数据
            Admin admin = admins.get(0);
            //确认admin不是null
            if(admin != null){
                //密码比较
                String md5Pwd = Md5Util.md5Encrypt(userPswd);
                if (Objects.equals(admin.getUserPswd(),md5Pwd)){
                    return admin;
                }

            }

        }

        return null;
    }
}
