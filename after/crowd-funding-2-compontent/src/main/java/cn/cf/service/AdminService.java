package cn.cf.service;

import cn.cf.entity.Admin;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author ：ZWQ
 * @version ：1.0
 * @date ：2019/11/30 - 16:43
 * @description ：
 */
public interface AdminService {

    /**
     * 查询所有
     */
    List<Admin> getAll();

    /**
     * 测试更新
     */
    void updateAdmin();

    /**
     * 登录方法
     * @param loginAcct
     * @param userPswd
     * @return admin
     */
    Admin login(String loginAcct, String userPswd);


    /**
     * 根据关键字搜索
     * @param pageNum  当前页码
     * @param pageSize 每页数量
     * @param keyword  查询关键字
     * @return 返回PageInfo 分页操作
     */
    PageInfo<Admin> queryForKeyword(Integer pageNum,Integer pageSize,String keyword);

}
