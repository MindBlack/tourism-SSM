package cn.bm.ssm.controller;

import cn.bm.ssm.domain.Orders;
import cn.bm.ssm.service.OrdersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    /**
     * 通过id查询详情
     * @param id
     * @param modelAndView
     * @return
     */
    @RequestMapping("/findById")
    public ModelAndView findById(String id,ModelAndView modelAndView) throws Exception {
        Orders orders = ordersService.findById(id);
        modelAndView.addObject("orders",orders);
        modelAndView.setViewName("orders-show");
        return modelAndView;
    }

    /**
     * 查询所有
     * @return
     */
//    @RequestMapping("/findAll")
//    public ModelAndView findAll(){
//        ModelAndView modelAndView = new ModelAndView();
//        List<Orders> ordersList = ordersService.findAll();
//        modelAndView.addObject("ordersList",ordersList);
//        modelAndView.setViewName("orders-list");
//        return modelAndView;
//    }

    /**
     * 查询订单并分页
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name="page")int page,@RequestParam(name="pageSize")int pageSize) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Orders> ordersList = ordersService.findAll(page,pageSize);
        PageInfo pageInfo = new PageInfo(ordersList);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("orders-page-list");
        return modelAndView;
    }

}
