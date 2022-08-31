package com.example.gxutrainbranch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author MaoMao
 * @Description
 * @create 2022-08-31 4:07 PM
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * 分页实体
 * TableData: 页面数据
 * total: 数据总量
 */
public class Page {
    private Object tableData;
    private Integer total;
}
