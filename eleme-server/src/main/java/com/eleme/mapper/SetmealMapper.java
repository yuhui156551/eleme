package com.eleme.mapper;

import com.eleme.annotation.AutoFill;
import com.eleme.entity.Setmeal;
import com.eleme.enumeration.OperationType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SetmealMapper {

    /**
     * 根据分类id查询套餐的数量
     * @param id
     * @return
     */
    @Select("select count(id) from setmeal where category_id = #{categoryId}")
    Integer countByCategoryId(Long id);

    //自定义注解
    @AutoFill(OperationType.INSERT)
    void insert(Setmeal setmeal);
}
