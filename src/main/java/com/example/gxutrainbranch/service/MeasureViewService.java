package com.example.gxutrainbranch.service;

import com.example.gxutrainbranch.dao.MeasureViewDao;
import com.example.gxutrainbranch.entity.MeasureView;
import com.example.gxutrainbranch.entity.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MaoMao
 * @Description 视图
 * @create 2022-09-01 5:09 PM
 */

@Service("MeasureViewService")
public class MeasureViewService {
    @Autowired
    MeasureViewDao measureViewDao;
    public List<MeasureView> queryId(long id){
        return measureViewDao.queryId(id);
    }
    /***
     * 普通查询（按自增查询）
     * @param currentPage   第几页
     * @param numberPerPage 一页含有几个
     * @return
     */
    public Page queryView(int currentPage,int numberPerPage){
        return new Page(measureViewDao.queryView((currentPage - 1) * numberPerPage, numberPerPage), measureViewDao.count());
    }

    /***
     * 升序查询
     * @param currentPage   第几页
     * @param numberPerPage 一页几个
     * @return
     */
    public Page queryDesc(int currentPage,int numberPerPage){
        return new Page(measureViewDao.queryDesc((currentPage - 1) * numberPerPage, numberPerPage), measureViewDao.count());
    }

    /***
     * 降序查询
     * @param currentPage   第几页
     * @param numberPerPage 一页几个
     * @return
     */
    public Page queryAsc(int currentPage,int numberPerPage){
        return new Page(measureViewDao.queryAsc((currentPage - 1) * numberPerPage, numberPerPage), measureViewDao.count());
    }
}
