package com.test.service.impl;

import com.test.DTO.OrderDTO;
import com.test.service.IOrderService;
import com.test.util.JsonResponseBody;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class OrderServiceImplTest {

    @Autowired
    private IOrderService orderService;


    @Test
    public void queryConTable() {
        OrderDTO orderDTO=new OrderDTO();
        JsonResponseBody jsonResponseBody = orderService.queryConTable(orderDTO);
        Object data = jsonResponseBody.getData();
        System.out.println(data);

    }
}