package com.test.service.impl;

import com.test.DTO.OrderDTO;
import com.test.model.Order;
import com.test.mapper.OrderMapper;
import com.test.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.util.JsonResponseBody;
import com.test.util.JsonResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lz
 * @since 2022-11-25
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public JsonResponseBody queryConTable(OrderDTO orderDTO) {
        List<OrderDTO> orderDTOS = orderMapper.queryConTable(orderDTO);
        if (null==orderDTOS||orderDTOS.size()==0){
            return new JsonResponseBody(JsonResponseStatus.NULLVALUE.getCode(),JsonResponseStatus.NULLVALUE.getMsg());
        }
        return new JsonResponseBody(orderDTOS);
    }
}
