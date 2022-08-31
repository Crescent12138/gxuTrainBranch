package com.example.gxutrainbranch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author MaoMao
 * @Description
 * @create 2022-08-31 2:17 PM
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentMeasurePoint {
    private int studentMeasurePointId;
    private int activityId;
    private double activityScore;
    private int studentID;
}