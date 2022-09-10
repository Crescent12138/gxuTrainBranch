package com.example.gxutrainbranch.service;

import com.example.gxutrainbranch.dao.SqlDao;
import com.example.gxutrainbranch.dao.StudentInformationDao;
import com.example.gxutrainbranch.dao.StudentMeasurePointDao;
import com.example.gxutrainbranch.entity.Page;
import com.example.gxutrainbranch.entity.StudentInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MaoMao
 * @Description 学生信息的功能
 * @create 2022-08-31 10:02 PM
 */

@Service("InfoService")
public class InfoService {
    @Autowired
    StudentInformationDao studentInformationDao;
    @Autowired
    StudentMeasurePointDao studentMeasurePointDao;
    @Autowired
    SqlDao sqlDao;
    /***
     *
     * @param studentInformation    添加学生信息实例
     * @return  返回是否成功
     */
    public boolean addInfo(StudentInformation studentInformation){
        return  studentInformationDao.addInformation(studentInformation) == 1;
    }

    /***
     *
     * @param id    删除的学生id
     * @return  返回是否成功
     */
    public boolean delInfo(Long id){
//        sqlDao.setKey();
        studentMeasurePointDao.delNameId(id);
        studentInformationDao.delInformation(id);
//        sqlDao.resetKey();
        return true;
    }

    /***
     *
     * @param studentInformation    修改的学生信息
     * @return  返回是否成功
     */
    public boolean updateInfo(StudentInformation studentInformation){
        return  studentInformationDao.updateInformation(studentInformation) == 1;
    }

    /***
     *
     * @param currentPage   当前第几页
     * @param numberPerPage 一页需要展示几个数据
     * @return  一页展示的数据量，以及总数量
     */
    public Page queryInfo(Integer currentPage, Integer numberPerPage) {
        return new Page(studentInformationDao.queryInformation((currentPage - 1) * numberPerPage, numberPerPage), studentInformationDao.count());
    }

    /***
     * 模糊查询
     * @param regex         正则值
     * @param currentPage   当前第几页
     * @param numberPerPage 一页展示几个数据
     * @return
     */
    public Page queryRegex(String regex,Integer currentPage, Integer numberPerPage) {
        return new Page(studentInformationDao.queryRegex(regex,(currentPage - 1) * numberPerPage, numberPerPage), studentInformationDao.count());
    }


    /***
     * 模糊查询
     * @param regex         正则值
     * @param currentPage   当前第几页
     * @param numberPerPage 一页展示几个数据
     * @return
     */
    public Page queryRegexDesc(String regex,Integer currentPage, Integer numberPerPage) {
        return new Page(studentInformationDao.queryRegexDesc(regex,(currentPage - 1) * numberPerPage, numberPerPage), studentInformationDao.count());
    }


    /***
     * 模糊查询
     * @param regex         正则值
     * @param currentPage   当前第几页
     * @param numberPerPage 一页展示几个数据
     * @return
     */
    public Page queryRegexAsc(String regex,Integer currentPage, Integer numberPerPage) {
        return new Page(studentInformationDao.queryRegexAsc(regex,(currentPage - 1) * numberPerPage, numberPerPage), studentInformationDao.count());
    }

    public StudentInformation queryId(Integer id){
        List<StudentInformation> ls = studentInformationDao.findId(id);
        return ls.get(0);
    }
    public Integer queryRank(String course,int id){
        String pro = course.substring(0,course.length() - 2);
        List<StudentInformation>st = studentInformationDao.findCourse(pro);
        for(int i = 0 ; i < st.size(); i ++){
            if (st.get(i).getStudentID() == id ) {
                return i;
            }
        }
        return 0;
    }
    public Integer querySize(String course){
        String pro = course.substring(0,course.length() - 2);
        List<StudentInformation>st = studentInformationDao.findCourse(pro);

        return st.size();
    }
}
