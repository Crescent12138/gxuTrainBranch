package com.example.gxutrainbranch.dao;

import com.example.gxutrainbranch.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author MaoMao
 * @Description
 * @create 2022-08-31 3:37 PM
 */

@Mapper
@Component(value = "AdminDao")
public interface AdminDao {
    /***
     *
     * @param offset 偏移量
     * @param count 最大行数
     * @return Page[offset+1, offset+count]
     */
    List<Admin> queryByPage(int offset, int count);

    /***
     *
     * @param admin 管理员实例
     * @return 判断是否发生了变化，变化则添加
     */
    int addAdmin(Admin admin);

    /***
     *
     * @param userId 管理员id
     * @return 判断是否发生了变化，变化则删除
     */
    int delAdmin(int userId);

    /***
     *
     * @param admin 管理员实例
     * @return 判断是否发生变化，变化则修改
     */
    int updateAdmin(Admin admin);

    /***
     *
     * @return 管理员数量
     */
    int getCount();

    /***
     *
     * @param userName 管理名
     * @return 管理员实例
     */
    List<Admin>getByUsername(String userName);


}
