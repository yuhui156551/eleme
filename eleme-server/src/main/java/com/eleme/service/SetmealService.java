package com.eleme.service;

import com.eleme.dto.SetmealDTO;
import com.eleme.dto.SetmealPageQueryDTO;
import com.eleme.entity.Setmeal;
import com.eleme.result.PageResult;
import com.eleme.vo.DishItemVO;
import com.eleme.vo.SetmealVO;

import java.util.List;

public interface SetmealService {
    
    void save(SetmealDTO setmealDTO);

    PageResult pageQuery(SetmealPageQueryDTO setmealPageQueryDTO);

    void deleteBatch(List<Long> ids);
    
    SetmealVO getByIdWithDish(Long id);
    
    void update(SetmealDTO setmealDTO);

    /**
     * 条件查询
     * @param setmeal
     * @return
     */
    List<Setmeal> list(Setmeal setmeal);

    /**
     * 根据id查询菜品选项
     * @param id
     * @return
     */
    List<DishItemVO> getDishItemById(Long id);

}