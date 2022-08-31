package com.example.gxutrainbranch.dao;

import com.example.gxutrainbranch.entity.Activity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author MaoMao
 * @Description
 * @create 2022-08-31 3:38 PM
 */
@Mapper
@Component(value = "ActivityDao")

public interface ActivityDao {
    /***
     *
     * @param type      类型
     * @param offset    偏移量
     * @param count     数量
     * @return  访问列表
     */
    List<Activity> queryType(String type,int offset,int count);

    /***
     *
     * @param activity   活动实体
     * @return  变化量
     */
    int addActivity(Activity activity);

    /***
     *
     * @param id    活动id
     * @return  变化量
     */
    int delActivity(int id);

    /***
     *
     * @param  id 活动实体
     * @return
     */
    int updateActivity(int id);

    /***
     *
     * @param type  类型
     * @return 数量
     */
    int getCount(String type);
}
