package com.example.gxutrainbranch.service;

import com.example.gxutrainbranch.dao.StudentMeasurePointDao;
import com.example.gxutrainbranch.entity.Page;
import com.example.gxutrainbranch.entity.StudentMeasurePoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MaoMao
 * @Description
 * @create 2022-09-01 10:10 AM
 */

@Service("MeasurePointService")
public class MeasurePointService {
    @Autowired
    StudentMeasurePointDao studentMeasurePointDao;

    /***
     * 添加综测
     * @param studentMeasurePoint   单项综测实例
     * @return  综测信息
     */
    public boolean addMeasure(StudentMeasurePoint studentMeasurePoint){
        if(studentMeasurePointDao.addStudentMeasurePoint(studentMeasurePoint) == 1){
            return true;
        }
        return false;
    }

    /***
     * 删除综测
     * @param id 综测id
     * @return  是否成功
     */

    public boolean delMeasure(int id){
        if(studentMeasurePointDao.delStudentMeasurePoint(id) == 1){
            return true;
        }
        return false;
    }

    /***
     * 修改综测
     * @param studentMeasurePoint   综测实例
     * @return 是否成功
     */
    public boolean updateMeasure(StudentMeasurePoint studentMeasurePoint){
        if(studentMeasurePointDao.updateStudentMeasurePoint(studentMeasurePoint) == 1){
            return true;
        }
        return false;
    }

    /***
     * 测试用综测基本表查询
     * @param type  查询型号
     * @param currentPage      第几页
     * @param numberPerPage    一页几个
     * @return  一页的内容
     */
    public Page queryType(String type,int currentPage,int numberPerPage){
        return new Page(studentMeasurePointDao.queryTypeStudentMeasurePoint(type,(currentPage - 1) * numberPerPage, numberPerPage), studentMeasurePointDao.count(type));
    }
    /***
     * 测试用综测基本表查询
     * @param type  查询学生id
     * @param currentPage      第几页
     * @param numberPerPage    一页几个
     * @return  一页的内容
     */
    public Page queryId(int type,int currentPage,int numberPerPage){
        return new Page(studentMeasurePointDao.queryUserMeasurePoint(type,(currentPage - 1) * numberPerPage, numberPerPage), studentMeasurePointDao.count(type));
    }
}
