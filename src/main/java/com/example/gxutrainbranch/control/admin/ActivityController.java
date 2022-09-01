package com.example.gxutrainbranch.control.admin;

import com.example.gxutrainbranch.entity.Activity;
import com.example.gxutrainbranch.entity.Page;
import com.example.gxutrainbranch.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author MaoMao
 * @Description
 * @create 2022-08-31 11:01 PM
 */

@RestController
@RequestMapping("/api/admin/activity")
public class ActivityController {
    @Autowired
    ActivityService activityService;

    /***
     * 添加活动
     * @param activity  活动实例
     * @return
     */
    @PostMapping()
    public String addActivity(@RequestBody Activity activity){
        if(activityService.addActivity(activity)){
            return "增加成功";
        }
        return "数据库插入失败，请稍后再试";
    }

    /***
     * 查询
     * @param current   第几页
     * @param count     一页几个
     * @param item      活动大类型（竞赛，社会实践，操行）
     * @return
     */
    @GetMapping ("/{item}")
    public Page query(int current ,int count,@PathVariable String item){
        return activityService.queryActivity(current,count,item);
    }

    /***
     * 删除单项活动
     * @param id    需要删除的id
     * @return
     */
    @DeleteMapping()
    public String del(int id){
        if(activityService.delActivity(id)){
            return "删除成功";
        }
        return "数据库异常，删除失败";
    }

    /***
     * 修改活动
     * @param activity  活动实体
     * @return
     */
    @PutMapping()
    public String update(@RequestBody Activity activity){
        if(activityService.updateActivity(activity)){
            return "修改成功";
        }
        return "修改失败，数据库异常";
    }
}
