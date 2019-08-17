package cn.bm.ssm.service;

import cn.bm.ssm.domain.Orders;

import java.util.List;

public interface OrdersService {
    /**
     * 通过id查询详情
     * @param id
     * @return
     */
    Orders findById(String id) throws Exception;

    /**
     * 查询多有订单
     * @return
     */
    List<Orders> findAll(int page,int pageSize) throws Exception;


}
