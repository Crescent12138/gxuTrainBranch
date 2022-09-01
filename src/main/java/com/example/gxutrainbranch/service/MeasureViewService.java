package com.example.gxutrainbranch.service;

import com.example.gxutrainbranch.dao.MeasureViewDao;
import com.example.gxutrainbranch.entity.MeasureView;
import com.example.gxutrainbranch.entity.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MaoMao
 * @Description 视图
 * @create 2022-09-01 5:09 PM
 */

@Service("MeasureViewService")
public class MeasureViewService {
    @Autowired
    MeasureViewDao measureViewDao;
    public Page queryView(int currentPage,int numberPerPage){
        return new Page(measureViewDao.queryView((currentPage - 1) * numberPerPage, numberPerPage), measureViewDao.count());
    }
}
