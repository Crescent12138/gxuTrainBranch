package com.example.gxutrainbranch.dao;

import com.example.gxutrainbranch.entity.StudentMeasurePoint;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author MaoMao
 * @Description
 * @create 2022-08-31 3:37 PM
 */

@Mapper
@Component(value = "StudentMeasurePointDao")
public interface StudentMeasurePointDao {
    /***
     *
     * @param userId 用户id
     * @param offset 偏移量
     * @param count  总个数
     * @return
     */
    List<StudentMeasurePoint> queryUserMeasurePoint(int userId,int offset,int count);

    /***
     *
     * @param studentMeasurePoint 添加一次综测
     * @return 改变行数
     */
    int addStudentMeasurePoint(StudentMeasurePoint studentMeasurePoint);

    /***
     *
     * @param id 学生综测单行的id
     * @return 改变行数
     */
    int delStudentMeasurePoint(int id);
    int delNameId(int id);
    /***
     *
     * @param studentMeasurePoint 学生-综测实例
     * @return 改变行数
     */
    int updateStudentMeasurePoint(StudentMeasurePoint studentMeasurePoint);

    /***
     *
     * @param type      活动类型
     * @param offset    偏移量
     * @param count     数量
     * @return
     */
    List<StudentMeasurePoint> queryTypeStudentMeasurePoint(String type,int offset,int count);

    /***
     *
     * @param type 活动类型
     * @return 数量
     */
    int count(String type);

    /***
     *
     * @param userId 用户id
     * @return  数量
     */
    int count(int userId);
}
