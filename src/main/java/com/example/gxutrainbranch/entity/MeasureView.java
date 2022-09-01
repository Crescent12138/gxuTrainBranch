package com.example.gxutrainbranch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author MaoMao
 * @Description
 * @create 2022-09-01 11:34 AM
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MeasureView {
    private int studentMeasurePointId;
    private Activity activity;
    private StudentInformation studentInformation;
    private double activityScore;
}
