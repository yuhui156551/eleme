package com.eleme.controller.admin;

import com.eleme.dto.DishDTO;
import com.eleme.dto.DishPageQueryDTO;
import com.eleme.entity.Dish;
import com.eleme.result.PageResult;
import com.eleme.result.Result;
import com.eleme.service.DishService;
import com.eleme.vo.DishVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yuhui
 * @date 2024/9/4 18:54
 */
@RestController
@RequestMapping("/admin/dish")
@Api(tags = "菜品相关接口")
@Slf4j
public class DishController {
    
    @Autowired
    private DishService dishService;
    
    @GetMapping("/list") 
    @ApiOperation("根据分类id查询菜品")
    public Result<List<Dish>> list(Long categoryId){//query查询，直接在路径后面拼接
        List<Dish> dishList = dishService.list(categoryId);
        return Result.success(dishList);
    }
    
    @PostMapping
    @ApiOperation("新增菜品")
    public Result save(@RequestBody DishDTO dishDTO) {
        dishService.saveWithFlavor(dishDTO);
        return Result.success();
    }

    @GetMapping("/page")
    @ApiOperation("菜品分页查询")
    public Result<PageResult> page(DishPageQueryDTO dishPageQueryDTO) {
        PageResult pageResult = dishService.pageQuery(dishPageQueryDTO);
        return Result.success(pageResult);
    }

    @DeleteMapping
    @ApiOperation("菜品批量删除")
    public Result delete(@RequestParam List<Long> ids) {
        dishService.deleteBatch(ids);//后绪步骤实现
        return Result.success();
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询菜品")
    public Result<DishVO> getById(@PathVariable Long id) {
        DishVO dishVO = dishService.getByIdWithFlavor(id);//后绪步骤实现
        return Result.success(dishVO);
    }

    @PutMapping
    @ApiOperation("修改菜品")
    public Result update(@RequestBody DishDTO dishDTO) {
        dishService.updateWithFlavor(dishDTO);
        return Result.success();
    }
}
