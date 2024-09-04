package com.eleme.controller.admin;

import com.eleme.entity.Dish;
import com.eleme.result.Result;
import com.eleme.service.DishService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yuhui
 * @date 2024/9/4 18:54
 */
@RestController
@RequestMapping("/admin/dish")
@Api(tags = "套餐相关接口")
@Slf4j
public class DishController {
    
    @Autowired
    private DishService dishService;
    
    @GetMapping("/list")
    public Result<List<Dish>> list(Long categoryId){//query查询，直接在路径后面拼接
        List<Dish> dishList = dishService.list(categoryId);
        return Result.success(dishList);
    }
}
