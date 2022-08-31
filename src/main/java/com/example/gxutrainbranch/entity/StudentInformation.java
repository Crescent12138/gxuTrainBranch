package com.example.gxutrainbranch.entity;

/**
 * @author MaoMao
 * @Description
 * @create 2022-08-31 2:13 PM
 */




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentInformation {
    private String studentClass;
    private String studentCourse;
    private long studentID;
    private String studentName;
    private double studentScore;
    private boolean studentSex;


}
