package com.example.orderservice.util;


import com.example.orderservice.dto.impl.OrderDTO;
import com.example.orderservice.entity.impl.Order;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    private ModelMapper modelMapper;

    public Mapping(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    //order mapping
    public Order toOrderEntity(OrderDTO orderDTO) {
        return modelMapper.map(orderDTO, Order.class);
    }

    public OrderDTO toOrderDTO(Order order) {
        return modelMapper.map(order, OrderDTO.class);
    }

    public List<Order> toOrderEntityList(List<OrderDTO> orderDTOs) {
        return modelMapper.map(orderDTOs, new TypeToken<List<Order>>() {}.getType());
    }

    public List<OrderDTO> toOrderDTOList(List<Order> orders) {
        return modelMapper.map(orders, new TypeToken<List<OrderDTO>>() {}.getType());
    }
}
