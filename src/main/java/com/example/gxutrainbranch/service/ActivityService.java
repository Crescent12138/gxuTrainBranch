package com.example.gxutrainbranch.service;

import com.example.gxutrainbranch.dao.ActivityDao;
import com.example.gxutrainbranch.entity.Activity;
import com.example.gxutrainbranch.entity.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MaoMao
 * @Description
 * @create 2022-08-31 10:59 PM
 */

@Service("ActivityService")
public class ActivityService {
    @Autowired
    ActivityDao activityDao;

    /***
     * 增加活动
     * @param activity  活动实体
     * @return
     */
    public boolean addActivity(Activity activity){
        if(activityDao.addActivity(activity) == 1) {
            return true;
        }
        return false;
    }

    /***
     * 删除活动
     * @param id 删除活动号
     * @return
     */
    public boolean delActivity(int id){
        if(activityDao.delActivity(id) == 1){
            return true;
        }
        return false;
    }

    /****
     * 修改活动
     * @param activity  活动实体
     * @return
     */
    public boolean updateActivity(Activity activity){
        if(activityDao.updateActivity(activity) == 1){
            return true;
        }
        return false;
    }

    /***
     * 分页查询
     * @param currentPage   第几页
     * @param numberPerPage 一页展示的数量
     * @param type  活动类型
     * @return  一页内容和内容总数
     */
    public Page queryActivity(int currentPage, int numberPerPage, String type){
        return new Page(activityDao.queryType(type,(currentPage - 1) * numberPerPage, numberPerPage), activityDao.getCount(type));
    }
}
