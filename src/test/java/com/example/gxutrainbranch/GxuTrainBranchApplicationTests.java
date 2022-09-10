package com.example.gxutrainbranch;

import com.example.gxutrainbranch.entity.Admin;
import com.example.gxutrainbranch.entity.Page;
import com.example.gxutrainbranch.service.InfoService;
import com.example.gxutrainbranch.utils.JwtUtils;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.io.UnsupportedEncodingException;

@SpringBootTest
class GxuTrainBranchApplicationTests {

        JwtUtils jwtUtils =new JwtUtils();


    @Test
    void contextLoads() throws UnsupportedEncodingException {
        Admin admin = new Admin();

    }
    @Autowired
    InfoService infoService;

    @Test
    void testInfo(){
       Page pp=  infoService.queryRegex("8",1,100);
    }


}
