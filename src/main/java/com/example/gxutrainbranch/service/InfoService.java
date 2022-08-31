package com.example.gxutrainbranch.service;

import com.example.gxutrainbranch.dao.StudentInformationDao;
import com.example.gxutrainbranch.entity.Page;
import com.example.gxutrainbranch.entity.StudentInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MaoMao
 * @Description
 * @create 2022-08-31 10:02 PM
 */

@Service("InfoService")
public class InfoService {
    @Autowired
    StudentInformationDao infoDao;

    /***
     *
     * @param studentInformation    添加学生信息实例
     * @return  返回是否成功
     */
    public boolean addInfo(StudentInformation studentInformation){
        return  infoDao.addInformation(studentInformation) == 1;
    }

    /***
     *
     * @param id    删除的学生id
     * @return  返回是否成功
     */
    public boolean delInfo(int id){
        return  infoDao.delInformation(id) == 1;
    }

    /***
     *
     * @param studentInformation    修改的学生信息
     * @return  返回是否成功
     */
    public boolean updateInfo(StudentInformation studentInformation){
        return  infoDao.updateInformation(studentInformation) == 1;
    }

    /***
     *
     * @param currentPage   当前第几页
     * @param numberPerPage 一页需要展示几个数据
     * @return  一页展示的数据量，以及总数量
     */
    public Page queryInfo(Integer currentPage, Integer numberPerPage) {
        return new Page(infoDao.queryInformation((currentPage - 1) * numberPerPage, numberPerPage), infoDao.count());
    }
}
