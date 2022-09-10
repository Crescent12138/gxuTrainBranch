package com.example.gxutrainbranch.control.admin;

import com.alibaba.fastjson.JSON;
import com.example.gxutrainbranch.dao.ActivityDao;
import com.example.gxutrainbranch.entity.Admin;
import com.example.gxutrainbranch.entity.Page;
import com.example.gxutrainbranch.entity.StudentInformation;
import com.example.gxutrainbranch.service.ActivityService;
import com.example.gxutrainbranch.service.AdminService;
import com.example.gxutrainbranch.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import javax.websocket.server.PathParam;
import java.util.HashMap;

/**
 * @author MaoMao
 * @Description
 * @create 2022-08-31 11:02 PM
 */

@RestController
@CrossOrigin
@RequestMapping("/api/admin/Info")
public class InfoController {
    @Autowired
    InfoService infoService;
    @Autowired
    AdminService adminService;
    /***
     * 添加信息
     * @param studentInformation   用户信息实例
     * @return 成功或失败原因
     */
    @PostMapping()
    public String addInfo(@RequestBody HashMap<String ,Object> studentInformation){

        Admin admin = new Admin();
        admin.setUserName(String.valueOf(studentInformation.get("studentID")));
        admin.setType(0);
        admin.setUserPassword("123456");
        StudentInformation stu = JSON.parseObject(JSON.toJSONString(studentInformation), StudentInformation.class);
        stu.setStudentClass("计科202");
//        if(adminService.queryId(admin.getUserName()))
        if(adminService.findAdmin(admin.getUserName())){
            infoService.updateInfo(stu);
            return "exist";
        }else adminService.addAdmin(admin);
        return "ok";
    }

    /***
     * 分页查询信息
     * @param currentPage   第几页
     * @param numberPerPage 一页几个
     * @return
     */
    @GetMapping
    public Page getInfo(@PathParam("currentPage") Integer currentPage, @PathParam("numberPerPage") Integer numberPerPage){
        Page page = infoService.queryInfo(currentPage,numberPerPage);
        return page;
    }
    @PostMapping("/regex")
    public Page getInfo(@RequestBody HashMap<String,String >mp){
        String search = mp.get("search");
        Page page = infoService.queryRegex(search,1,100);
        return page;
    }

    /***
     * 删除信息
     * @param id    信息编号
     * @return  成功或失败原因
     */
    @DeleteMapping
    public String delInfo(@PathParam("id") Long  id){
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
    @PostMapping("/uid")
    public HashMap<String , Object> userData(Integer userId){
        HashMap<String,Object> mp = new HashMap<String,Object>();
        StudentInformation st = infoService.queryId(userId);
        Admin ad = adminService.queryId(userId);
        mp.put("person",st);
        if(ad.getType() == 1)
            mp.put("authority","管理");
        else
            mp.put("authority","学生");
        Integer typeRank = infoService.queryRank(st.getStudentClass(),userId);
        mp.put("rank_type",typeRank);
        double rank = 1.0* typeRank / infoService.querySize(st.getStudentClass());
        mp.put("rank_type",rank);
        return mp;
    }
}
