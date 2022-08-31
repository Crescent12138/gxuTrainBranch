package com.example.gxutrainbranch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author MaoMao
 * @Description
 * @create 2022-08-31 3:21 PM
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String createTime;
    private String userId;
    private String userName;
    private String userPassword;
}
