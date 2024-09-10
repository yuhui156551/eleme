package com.eleme.service;

import com.eleme.dto.OrdersSubmitDTO;
import com.eleme.result.PageResult;
import com.eleme.vo.OrderSubmitVO;
import com.eleme.vo.OrderVO;

public interface OrderService {

    /**
     * 用户下单
     * @param ordersSubmitDTO
     * @return
     */
    OrderSubmitVO submitOrder(OrdersSubmitDTO ordersSubmitDTO);

    /**
     * 用户端订单分页查询 订单状态 1待付款 2待接单 3已接单 4派送中 5已完成 6已取消
     * @param page
     * @param pageSize
     * @param status
     * @return
     */
    PageResult pageQueryOrders(int page, int pageSize, Integer status);

    /**
     * 订单详情
     * @param id
     * @return
     */
    OrderVO details(Long id);
}