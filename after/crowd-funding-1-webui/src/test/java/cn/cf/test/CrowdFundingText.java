package cn.cf.test;

import cn.cf.entity.Admin;
import cn.cf.mapper.AdminMapper;
import cn.cf.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author ：ZWQ
 * @version ：1.0
 * @date ：2019/11/30 - 19:50
 * @description ：
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("src/main/resources")
@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml","classpath:spring-persist-tx.xml", "classpath:springmvc.xml"})
public class CrowdFundingText {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private AdminService adminService;
    @Autowired
    private AdminMapper adminMapper;

    /**
     * spring整合mybatis测试数据库连接
     * @throws SQLException
     */
    @Test
    public void testConnection() throws SQLException{

        Connection connection  = dataSource.getConnection();
        System.out.println(connection);
    }

    /**
     * 测试spring整合mybatis
     */
    @Test
    public void testMybatis(){

        List<Admin> all = adminService.getAll();
        for (Admin admin:all) {
            System.out.println(admin);
        }
    }

    /**
     * 测试事务
     */
    @Test
    public void testTx(){
        adminService.updateAdmin();
    }

    /**
     * 测试sql根据关键字查询
     */
    @Test
    public void testSelectAdminByKeyword(){

        List<Admin> admins = adminMapper.selectAdminByKeyword("a");
        for(Admin admin:admins){
            System.out.println(admin);
        }
    }
}
