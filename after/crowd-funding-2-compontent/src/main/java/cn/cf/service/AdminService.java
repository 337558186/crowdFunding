package cn.cf.service;

import cn.cf.entity.Admin;

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
}
