package com.example.gxutrainbranch.dao;

import com.example.gxutrainbranch.entity.StudentInformation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author MaoMao
 * @Description
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
    int delInformation(int id);

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
}
