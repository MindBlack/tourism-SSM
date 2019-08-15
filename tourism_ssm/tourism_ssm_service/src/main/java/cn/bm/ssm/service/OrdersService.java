package cn.bm.ssm.service;

import cn.bm.ssm.domain.Orders;

import java.util.List;

public interface OrdersService {

    /**
     * 查询多有订单
     * @return
     */
    List<Orders> findAll(int page,int pageSize);
}
