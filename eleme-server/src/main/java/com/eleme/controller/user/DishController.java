package com.eleme.controller.user;


import com.eleme.constant.StatusConstant;
import com.eleme.entity.Dish;
import com.eleme.result.Result;
import com.eleme.service.DishService;
import com.eleme.vo.DishVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController("userDishController")
@RequestMapping("/user/dish")
@Slf4j
@Api(tags = "C端-菜品浏览接口")
public class DishController {
    @Autowired
    private DishService dishService;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 根据分类id查询菜品
     *
     * @param categoryId
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("根据分类id查询菜品")
    public Result<List<DishVO>> list(Long categoryId) {
        //加入redis缓存，缓存菜品
        
        //设定key
        String key = "dish_" + categoryId;
        //1、查询redis当中是否已经存了菜品数据，根据分类id获取菜品数据
        List<DishVO> dishList= (List<DishVO>) redisTemplate.opsForValue().get(key);
        //2、如果redis当中已经有了菜品数据，则可以直接返回数据，无需再查询数据库
        if(dishList != null && dishList.size() > 0){
            return Result.success(dishList);
        }
        //3、如果redis当中没有菜品数据，依照以往代码从数据库获取数据
        Dish dish = new Dish();
        dish.setCategoryId(categoryId);
        dish.setStatus(StatusConstant.ENABLE);//查询起售中的菜品

        List<DishVO> list = dishService.listWithFlavor(dish);
        //4、查询数据库之后，将数据放入redis当中
        redisTemplate.opsForValue().set(key, list);
        //5、返回数据
        return Result.success(list);
    }

}
