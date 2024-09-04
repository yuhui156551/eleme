package com.eleme.service;

import com.eleme.entity.Dish;

import java.util.List;

/**
 * @author yuhui
 * @date 2024/9/4 19:01
 */
public interface DishService {

    List<Dish> list(Long categoryId);
}
