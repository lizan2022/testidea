package com.test.mapper;

import com.test.DTO.OrderDTO;
import com.test.model.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lz
 * @since 2022-11-25
 */
 @Repository
public interface OrderMapper extends BaseMapper<Order> {
 List<OrderDTO> queryConTable(OrderDTO orderDTO);
}
