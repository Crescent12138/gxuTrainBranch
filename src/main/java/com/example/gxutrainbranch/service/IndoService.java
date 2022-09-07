package com.example.gxutrainbranch.service;

import com.example.gxutrainbranch.dao.ActivityDao;
import com.example.gxutrainbranch.dao.StudentInformationDao;
import com.example.gxutrainbranch.dao.StudentMeasurePointDao;
import com.example.gxutrainbranch.entity.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MaoMao
 * @Description
 * @create 2022-09-07 5:37 PM
 */

@Service
public class IndoService {
    @Autowired
    ActivityDao activityDao;
    @Autowired
    StudentMeasurePointDao studentMeasurePointDao;
    @Autowired
    StudentInformationDao studentInformationDao;

}
