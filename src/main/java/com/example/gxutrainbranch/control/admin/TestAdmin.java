package com.example.gxutrainbranch.control.admin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MaoMao
 * @Description
 * @create 2022-09-02 11:05 AM
 */

@RestController
@RequestMapping("/api/demo")
public class TestAdmin {
    @PostMapping()
    public String tes(){
            return "helo";
    }
}
