package com.example.gxutrainbranch.control.admin;

import com.alibaba.fastjson.JSON;
import com.example.gxutrainbranch.entity.*;
import com.example.gxutrainbranch.service.ActivityService;
import com.example.gxutrainbranch.service.MeasurePointService;
import com.example.gxutrainbranch.service.MeasureViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;

/**
 * @author MaoMao
 * @Description
 * @create 2022-09-01 10:54 AM
 */

@RestController
@CrossOrigin
@RequestMapping("/api/admin/Measure")
public class MeasurePointController {
    @Autowired
    MeasurePointService measurePointService;
    @Autowired
    ActivityService activityService;
    @Autowired
    MeasureViewService measureViewService;
    /***
     * 分页查询，仅测试用
     * @param current   第几页
     * @param count     一页有几个
     * @param item      需要查看的类型
     * @return
     */
    @GetMapping("/{item}")

    public Page query(int current, int count, @PathVariable String item){
        return measurePointService.queryType(item,current,count);
    }
    @GetMapping("/id")
    public List<MeasureView> queryId(@PathParam("studentId") long studentId){

       return  measureViewService.queryId(studentId);
    }

    /***
     * 增加
     * @param mp   综测实例
     * @return
     */
    @PostMapping("/{id}")
    public String add(@RequestBody HashMap<String,List<Activity>> mp,@PathVariable long id){
        List<Activity> tmp= mp.get("ls");
        measurePointService.delName(id);
//        List<Activity> ls = JSON.parseObject(JSON.toJSONString(mp),  List<Activity>.class);
        for (Activity activity : tmp){
            if(activity.getActivityName() == "")continue;
            long ids = activityService.check(activity);
            StudentMeasurePoint stu = new StudentMeasurePoint();
            stu.setStudentId(id);
            stu.setActivityId(ids);
            stu.setActivityScore(activity.getActivityScore());
            measurePointService.addMeasure(stu);
        }
        MeasureView measureView ;
        return "ok";
    }

    private String getString(@RequestBody MeasureView measureView) {
        activityService.check(measureView.getActivity());
        StudentMeasurePoint studentMeasurePoint = new StudentMeasurePoint();
        studentMeasurePoint.setStudentId(measureView.getStudentInformation().getStudentID());
        studentMeasurePoint.setStudentMeasurePointId(measureView.getStudentMeasurePointId());
        studentMeasurePoint.setActivityId(measureView.getActivity().getActivityId());
        studentMeasurePoint.setActivityScore(measureView.getActivity().getActivityScore());
        measurePointService.updateMeasure(studentMeasurePoint);
        return "修改成功";
    }

    /***
     * 删除
     *
     * @param ids 删除的综测id
     * @return
     */
    @DeleteMapping
    public String del(@RequestBody List<Integer> ids){
        for (Integer id : ids ){
            measurePointService.delMeasure(id);
        }

        return "ok";
//        if(measurePointService.delMeasure(id)){
//            return "删除成功";
//        }
//        return "删除失败，请稍后再试";
    }

    /***
     * 修改
     * @param measureView   修改后的综测内容
     * @return
     */
    @PutMapping
    public String update(@RequestBody MeasureView measureView){
        return getString(measureView);
    }


}
