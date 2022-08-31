package com.example.gxutrainbranch.control;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MaoMao
 * @Description
 * @create 2022-08-31 11:20 PM
 */

@RestController
@RequestMapping("/api/ping")
public class TestController {
    @GetMapping
    public String hello(){
        return "hello";
    }

    @PostMapping()
    public String hello2(){
        return "hello2";
    }
}
