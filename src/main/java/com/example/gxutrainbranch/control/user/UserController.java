package com.example.gxutrainbranch.control.user;
import com.example.gxutrainbranch.entity.Page;
import com.example.gxutrainbranch.entity.User;
import com.example.gxutrainbranch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author MaoMao
 * @Description
 * @create 2022-08-31 4:16 PM
 */

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public String addUser( @RequestBody User user) {
        if (userService.addAdmin(user)) {
            return  "添加成功";
        }
        return "数据库系统存在异常,请重试！";
    }

    /**
     * 分页获取用户列表
     *
     * @param currentPage 当前页
     * @param numberPerPage 每页数量
     * @return
     */
    @GetMapping
    public Page getByPage( int currentPage, int numberPerPage) {
        Page pagesEntity =  userService.getByPage(currentPage, numberPerPage);
        return  pagesEntity;
    }
}
