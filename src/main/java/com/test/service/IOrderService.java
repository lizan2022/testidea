package com.test.service;

import com.test.DTO.OrderDTO;
import com.test.model.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import com.test.util.JsonResponseBody;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lz
 * @since 2022-11-25
 */
public interface IOrderService extends IService<Order> {
    JsonResponseBody queryConTable(OrderDTO orderDTO);
}
