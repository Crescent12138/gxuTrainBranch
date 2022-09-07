package com.example.gxutrainbranch.control.admin;

import com.example.gxutrainbranch.service.IndoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MaoMao
 * @Description
 * @create 2022-09-07 5:38 PM
 */

@RestController
@CrossOrigin
@RequestMapping("/api/admin/Indo")
public class IndoController {
    @Autowired
    IndoService indoService;

}
