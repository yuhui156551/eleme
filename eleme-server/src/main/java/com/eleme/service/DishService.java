package com.eleme.service;

import com.eleme.dto.DishDTO;
import com.eleme.dto.DishPageQueryDTO;
import com.eleme.entity.Dish;
import com.eleme.result.PageResult;
import com.eleme.vo.DishVO;

import java.util.List;

/**
 * @author yuhui
 * @date 2024/9/4 19:01
 */
public interface DishService {

    List<Dish> list(Long categoryId);

    void saveWithFlavor(DishDTO dishDTO);

    PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO);

    void deleteBatch(List<Long> ids);

    DishVO getByIdWithFlavor(Long id);

    void updateWithFlavor(DishDTO dishDTO);
}
