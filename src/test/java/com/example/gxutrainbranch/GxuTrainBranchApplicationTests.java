package com.example.gxutrainbranch;

import com.example.gxutrainbranch.entity.Admin;
import com.example.gxutrainbranch.utils.JwtUtils;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;


import java.io.UnsupportedEncodingException;

@SpringBootTest
class GxuTrainBranchApplicationTests {

        JwtUtils jwtUtils =new JwtUtils();


    @Test
    void contextLoads() throws UnsupportedEncodingException {
        Admin admin = new Admin();

        admin.setUserName("MaoMao");


        String token = jwtUtils.createToken(admin);


        System.out.println(token);

    }


}
