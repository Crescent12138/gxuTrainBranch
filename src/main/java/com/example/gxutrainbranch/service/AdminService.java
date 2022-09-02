package com.example.gxutrainbranch.service;

import com.example.gxutrainbranch.dao.AdminDao;
import com.example.gxutrainbranch.entity.Admin;
import com.example.gxutrainbranch.entity.Page;
import com.example.gxutrainbranch.utils.JwtUtils;
import com.example.gxutrainbranch.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MaoMao
 * @Description
 * @create 2022-08-31 3:54 PM
 */

@Service("AdminService")
public class AdminService {
    @Autowired
    private AdminDao adminDao;

    /***
     *
     * @param admin 用户实体类
     * @return 是否添加成功
     */
    public Boolean addAdmin(Admin admin) {
        long createTime = System.currentTimeMillis();
        admin.setUserPassword(MD5Utils.string2MD5(admin.getUserPassword()));
        admin.setCreateTime(String.valueOf(createTime));
        return adminDao.addAdmin(admin) == 1;
    }
    /**
     * 删除用户
     *
     * @param id 用户编号
     * @return 是否删除成功
     */
    public Boolean delAdmin(Integer id) {
        return adminDao.delAdmin(id) == 1;
    }

    /**
     * 判断登录密码或用户名是否正确
     *
     * @param username 用户名
     * @param password 密码
     * @return 用户名与密码是否匹配
     */
    public String checkPassword(String username, String password) {
        List<Admin> userList = adminDao.getByUsername(username);
        if(userList.isEmpty()) return null;
        Admin user = userList.get(0);
        if(!MD5Utils.passwordIsTrue(password, user.getUserPassword())) return null;
        return signToken(username);
    }

    JwtUtils jwtUtils = new JwtUtils();

    /***
     * 签发验证token
     * @param userName
     * @return
     */
    private String signToken(String userName){
        return jwtUtils.generateToken(userName);
    }

    /**
     * 分页获取
     *
     * @param currentPage 当前页数
     * @param numberPerPage 每页有多少
     * @return 第currentPage页的管理员
     */
    public Page getByPage(Integer currentPage, Integer numberPerPage) {
        return new Page(adminDao.queryByPage((currentPage - 1) * numberPerPage, numberPerPage), adminDao.getCount());
    }

}
