package cn.cf.service.impl;

import cn.cf.entity.Admin;
import cn.cf.entity.AdminExample;
import cn.cf.mapper.AdminMapper;
import cn.cf.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Admin> getAll() {

        return adminMapper.selectByExample(new AdminExample());
    }

    public void updateAdmin() {

        adminMapper.updateByPrimaryKey(new Admin(1,"123123","哈利修改","harry","harry@qq.com",null));
        System.out.println("测试事务的执行");
       // System.out.println(10/0);
        adminMapper.updateByPrimaryKey(new Admin(2,"1231456","波比修改","body","body@qq.com",null));

    }
}
