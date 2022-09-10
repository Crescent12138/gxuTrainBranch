package com.example.gxutrainbranch.dao;

import com.example.gxutrainbranch.entity.MeasureView;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "MeasureViewDao")
public interface MeasureViewDao {

    /***
     * 分页查询视图
     * @param offset    偏移量
     * @param count     数量
     * @return
     */
     List<MeasureView>queryView(int offset,int count);
    List<MeasureView>queryId(long id);
    /***
     * 计数
     * @return
     */
    Integer count();

    /***
     * 升序排序，限定总分
     * @param offset    偏移量
     * @param count     数量
     * @return
     */
    List<MeasureView>queryDesc(int offset,int count);
    /***
     * 降序排序，限定总分
     * @param offset    偏移量
     * @param count     数量
     * @return
     */
    List<MeasureView>queryAsc(int offset,int count);


}
