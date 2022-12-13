package com.test.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.test.model.Order;
import com.test.service.IOrderService;
import com.test.util.JsonResponseBody;
import com.test.util.JsonResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.sql.Wrapper;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lz
 * @since 2022-11-25
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @RequestMapping("/list")
    public JsonResponseBody list(Order order){
        List<Order> list = orderService.list();
        if (null==list||list.size()==0){
            return new JsonResponseBody(JsonResponseStatus.NULLVALUE.getCode(),JsonResponseStatus.NULLVALUE.getMsg());
        }
        return new JsonResponseBody(list);
    }

    @RequestMapping("/save")
    public JsonResponseBody save(Order order){
        System.out.println("okok");
        boolean f = orderService.save(order);
        if (f){
            return new JsonResponseBody();
        }
        return new JsonResponseBody(JsonResponseStatus.INSERROT.getCode(),JsonResponseStatus.INSERROT.getMsg());

    }

    @RequestMapping("/delete")
    public JsonResponseBody delete(Order order){
        UpdateWrapper update=new UpdateWrapper();
        update.eq("order_id",order.getOrderId());
        boolean f = orderService.remove(update);
        if (f){
            return new JsonResponseBody();
        }
        return new JsonResponseBody(JsonResponseStatus.DELERROT.getCode(),JsonResponseStatus.DELERROT.getMsg());

    }

    @RequestMapping("/update")
    public JsonResponseBody update(Order order){
        UpdateWrapper updateWrapper=new UpdateWrapper();
        updateWrapper.eq("order_id",order.getOrderId());
        boolean f = orderService.update(order,updateWrapper);
        if (f){
            return new JsonResponseBody();
        }
        return new JsonResponseBody(JsonResponseStatus.UPDERROT.getCode(),JsonResponseStatus.UPDERROT.getMsg());

    }



}
