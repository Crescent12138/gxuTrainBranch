package com.example.gxutrainbranch.control.admin;

import com.example.gxutrainbranch.dao.MeasureViewDao;
import com.example.gxutrainbranch.entity.MeasureView;
import com.example.gxutrainbranch.entity.Page;
import com.example.gxutrainbranch.service.MeasureViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @author MaoMao
 * @Description
 * @create 2022-09-01 5:23 PM
 */

@RestController
@RequestMapping("/api/admin/View")
@CrossOrigin
public class MeasureController {
    @Autowired
    MeasureViewService measureViewService;

    @GetMapping()
    public Page queryByPage(int current,int count){
        return measureViewService.queryView(current, count);
    }

    @PostMapping()
    public void update(@RequestBody HashMap<String ,Object> mp){
        
    }
}
