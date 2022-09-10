package com.example.gxutrainbranch.dao;

import com.example.gxutrainbranch.entity.StudentInformation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author MaoMao
 * @Description 本页主要功能为对学生信息的操作
 * @create 2022-08-31 3:37 PM
 */

@Mapper
@Component(value = "StudentInformationDao")
public interface StudentInformationDao {
    /***
     *
     * @param offset
     * @param count
     * @return
     */
    List<StudentInformationDao>queryInformation(int offset ,int count);

    /***
     *
     * @param studentInformation 学生信息实体
     * @return
     */
    int addInformation(StudentInformation studentInformation);

    /***
     *
     * @param id 删除用户id
     * @return  变化量
     */
    int delInformation(Long id);

    /***
     *
     * @param studentInformation    学生信息实体
     * @return  变化量
     */
    int updateInformation(StudentInformation studentInformation);

    /***
     *
     * @return  返回总数量
     */
    int count();

    /***
     * 模糊查询
     * @param regex     正则值
     * @param offset    偏移量
     * @param count     数量
     * @return
     */
    List<StudentInformation>queryRegex(String regex,int offset,int count);

    /***
     * 模糊查询升序
     * @param regex     正则值
     * @param offset    偏移量
     * @param count     数量
     * @return
     */
    List<StudentInformation>queryRegexDesc(String regex,int offset,int count);
    /***
     * 模糊查询降序
     * @param regex     正则值
     * @param offset    偏移量
     * @param count     数量
     * @return
     */
    List<StudentInformation>queryRegexAsc(String regex,int offset,int count);

    int delName();

        List<StudentInformation>findId(int studentId);
        List<StudentInformation>findCourse(String course);
}
