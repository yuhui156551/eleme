package com.eleme.service;

import com.eleme.dto.SetmealDTO;
import com.eleme.dto.SetmealPageQueryDTO;
import com.eleme.result.PageResult;

public interface SetmealService {
    
    void save(SetmealDTO setmealDTO);

    PageResult pageQuery(SetmealPageQueryDTO setmealPageQueryDTO);
}