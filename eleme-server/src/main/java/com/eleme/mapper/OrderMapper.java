package com.eleme.mapper;

import com.eleme.dto.OrdersPageQueryDTO;
import com.eleme.entity.Orders;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    /**
     * 插入订单数据
     * @param order
     */
    void insert(Orders order);
    /**
     * 分页条件查询并按下单时间排序
     * @param ordersPageQueryDTO
     */
    Page<Orders> pageQuery(OrdersPageQueryDTO ordersPageQueryDTO);
}