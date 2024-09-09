package com.eleme.controller.user;

import com.eleme.dto.OrdersSubmitDTO;
import com.eleme.result.Result;
import com.eleme.service.OrderService;
import com.eleme.vo.OrderSubmitVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuhui
 * @date 2024/9/9 15:44
 */
@RestController
@RequestMapping("/user/order")
@Api(tags = "用户订单相关接口")
public class OrderController {
    @Autowired
    private OrderService orderService;
    
    @PostMapping("/submit")
    @ApiOperation("用户下单")
    public Result<OrderSubmitVO> submitOrder(@RequestBody OrdersSubmitDTO ordersSubmitDTO) {
        OrderSubmitVO orderSubmitVO = orderService.submitOrder(ordersSubmitDTO);
        return Result.success(orderSubmitVO);
    }
}
