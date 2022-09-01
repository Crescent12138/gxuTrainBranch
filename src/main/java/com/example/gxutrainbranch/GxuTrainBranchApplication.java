package com.example.gxutrainbranch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude= {SecurityAutoConfiguration.class })
public class GxuTrainBranchApplication {

    public static void main(String[] args) {
        SpringApplication.run(GxuTrainBranchApplication.class, args);
    }

}
