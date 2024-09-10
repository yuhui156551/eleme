package com.eleme.controller.admin;

import com.eleme.dto.OrdersPageQueryDTO;
import com.eleme.result.PageResult;
import com.eleme.result.Result;
import com.eleme.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuhui
 * @date 2024/9/10 9:45
 */
@RestController("adminOrderController")
@RequestMapping("/admin/order")
@Api("管理端订单接口")
public class OrderController {

    @Autowired
    private OrderService orderService;
    
    @GetMapping("/conditionSearch")
    @ApiOperation("订单搜索")
    public Result<PageResult> conditionSearch(OrdersPageQueryDTO ordersPageQueryDTO) {
        PageResult pageResult = orderService.conditionSearch(ordersPageQueryDTO);
        return Result.success(pageResult);
    }
}
