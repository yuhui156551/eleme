package com.eleme.mapper;

import com.eleme.entity.SetmealDish;

import java.util.List;

/**
 * @author yuhui
 * @date 2024/9/4 19:11
 */
public interface SetmealDishMapper {
    /**
     * 批量保存套餐和菜品的关联关系
     * @param setmealDishes
     */
    void insertBatch(List<SetmealDish> setmealDishes);
}
