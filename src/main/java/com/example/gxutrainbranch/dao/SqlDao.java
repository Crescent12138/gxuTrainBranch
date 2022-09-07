package com.example.gxutrainbranch.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author MaoMao
 * @Description
 * @create 2022-09-07 11:20 PM
 */

@Mapper
@Component(value = "SqlDao")
public interface SqlDao {
    @Transactional
    @Modifying
    @Query(value = "SET FOREIGN_KEY_CHECKS = 0")
    public void setKey();
    @Transactional
    @Modifying
    @Query(value = "SET FOREIGN_KEY_CHECKS = 1")
    public void resetKey();
}
