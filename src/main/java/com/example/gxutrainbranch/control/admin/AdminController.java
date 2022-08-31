package com.example.gxutrainbranch.control.admin;

import com.example.gxutrainbranch.entity.Page;
import com.example.gxutrainbranch.entity.Admin;
import com.example.gxutrainbranch.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author MaoMao
 * @Description
 * @create 2022-08-31 4:14 PM
 */

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    /***
     * 
     * @param admin 添加管理
     * @return 返回成功或者失败的参数
     */
    @PostMapping("/add")
    public String addAdmin( @RequestBody Admin admin) {
        if (adminService.addAdmin(admin)) {
            return  "添加成功";
        }
        return "数据库系统存在异常,请重试！";
    }

    /**
     * 分页获取管理员列表
     *
     * @param currentPage 当前页
     * @param numberPerPage 每页数量
     * @return
     */
    @GetMapping
    public Page getByPage(int currentPage, int numberPerPage) {
        Page pagesEntity =  adminService.getByPage(currentPage, numberPerPage);
        return  pagesEntity;
    }
}
