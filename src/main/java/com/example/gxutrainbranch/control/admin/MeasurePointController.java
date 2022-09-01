package com.example.gxutrainbranch.control.admin;

import com.example.gxutrainbranch.entity.Page;
import com.example.gxutrainbranch.entity.StudentMeasurePoint;
import com.example.gxutrainbranch.service.MeasurePointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author MaoMao
 * @Description
 * @create 2022-09-01 10:54 AM
 */

@RestController
@RequestMapping("/api/admin/Measure")
public class MeasurePointController {
    @Autowired
    MeasurePointService measurePointService;

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

    /***
     * 增加
     * @param studentMeasurePoint   综测实例
     * @return
     */
    @PostMapping
    public String add(@RequestBody StudentMeasurePoint studentMeasurePoint){
        if(measurePointService.addMeasure(studentMeasurePoint)){
            return "添加成功";
        }
        return "添加失败，请稍后再试";
    }

    /***
     * 删除
     *
     * @param id 删除的综测id
     * @return
     */
    @DeleteMapping
    public String del(int id){
        if(measurePointService.delMeasure(id)){
            return "删除成功";
        }
        return "删除失败，请稍后再试";
    }

    /***
     * 修改
     * @param studentMeasurePoint   修改后的综测内容
     * @return
     */
    @PutMapping
    public String update(@RequestBody StudentMeasurePoint studentMeasurePoint){
        if(measurePointService.updateMeasure(studentMeasurePoint)){
            return "修改成功";
        }
        return "修改失败，请稍后再试";
    }


}
