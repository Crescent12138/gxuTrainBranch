package com.example.gxutrainbranch.dao;

import com.example.gxutrainbranch.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author MaoMao
 * @Description
 * @create 2022-08-31 3:37 PM
 */

@Mapper
@Component(value = "UserDao")
public interface UserDao {
    /***
     *
     * @param offset 偏移量
     * @param count 最大行数
     * @return Page[offset+1, offset+count]
     */
    List<User> queryByPage(int offset, int count);

    /***
     *
     * @param user 学生用户实例
     * @return 判断是否发生了变化，变化则添加
     */
    int addUser(User user);

    /***
     *
     * @param userId 学生用户id
     * @return 判断是否发生了变化，变化则删除
     */
    int delUser(int userId);

    /***
     *
     * @param user 学生用户实例
     * @return 判断是否发生变化，变化则修改
     */
    int updateUser(User user);

    /***
     *
     * @return 学生用户数量
     */
    int getCount();

    /***
     *
     * @param userName 管理名
     * @return 学生用户实例
     */
    List<User>getByUsername(String userName);



}
