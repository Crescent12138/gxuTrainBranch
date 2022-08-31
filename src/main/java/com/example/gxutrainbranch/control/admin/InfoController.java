package com.example.gxutrainbranch.control.admin;

import com.example.gxutrainbranch.entity.Page;
import com.example.gxutrainbranch.entity.StudentInformation;
import com.example.gxutrainbranch.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author MaoMao
 * @Description
 * @create 2022-08-31 11:02 PM
 */

@RestController
@RequestMapping("/api/admin/Info")
public class InfoController {
    @Autowired
    InfoService infoService;

    /***
     * 添加信息
     * @param studentInformation   用户信息实例
     * @return 成功或失败原因
     */
    @PostMapping()
    public String addInfo(@RequestBody StudentInformation studentInformation){
        if(infoService.addInfo(studentInformation)){
            return "添加成功";
        }
        return "数据库系统存在异常，请重试";
    }

    /***
     * 分页查询信息
     * @param currentPage   第几页
     * @param numberPerPage 一页几个
     * @return
     */
    @GetMapping
    public Page getInfo(int currentPage, int numberPerPage){
        Page page = infoService.queryInfo(currentPage,numberPerPage);
        return page;
    }

    /***
     * 删除信息
     * @param id    信息编号
     * @return  成功或失败原因
     */
    @DeleteMapping
    public String delInfo(int id){
        if(infoService.delInfo(id)){
            return "删除成功";
        }
        return "没有该用户，请重新确认或者联系管理员";
    }

    /***
     * 修改信息
     * @param studentInformation    信息实例
     * @return  成功或失败的原因
     */
    @PutMapping
    public String updateInfo(@RequestBody StudentInformation studentInformation){
        if(infoService.updateInfo(studentInformation)){
            return "修改成功";
        }
        return "无法修改该用户，请重试";
    }
}
