package com.example.gxutrainbranch.control.pb;

import com.example.gxutrainbranch.entity.Admin;
import com.example.gxutrainbranch.service.AdminService;
import com.example.gxutrainbranch.utils.JwtUtils;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author MaoMao
 * @Description
 * @create 2022-09-02 4:59 PM
 */
@RestController
@CrossOrigin
@RequestMapping("/api/login")
public class login {
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    AdminService adminService;
    @PostMapping()
    public String log(@RequestBody Admin admin){

       String tmp =  adminService.checkPassword(admin.getUserName(),admin.getUserPassword());
       if(tmp == null){
           return "123123";
       }
       return tmp;
    }
}
