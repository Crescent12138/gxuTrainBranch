package com.example.gxutrainbranch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author MaoMao
 * @Description
 * @create 2022-08-31 2:20 PM
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Activity {
    private long activityId;
    private String activityName;
    private double activityScore;
    private String activityType;
    private String actionType;

}