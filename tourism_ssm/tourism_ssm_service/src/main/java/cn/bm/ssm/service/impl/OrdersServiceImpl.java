package cn.bm.ssm.service.impl;

import cn.bm.ssm.dao.OrdersDao;
import cn.bm.ssm.domain.Orders;
import cn.bm.ssm.service.OrdersService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;

    /**
     * 查询
     * @return
     */
    @Override
    public List<Orders> findAll(int page,int pageSize) {
        //分页插接来进行分页  pageNum-->当前页码  pageSize-->代表每页显示条数
        PageHelper.startPage(page,pageSize);
        return ordersDao.findAll();
    }
}
