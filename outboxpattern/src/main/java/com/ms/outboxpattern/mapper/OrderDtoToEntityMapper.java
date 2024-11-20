package com.ms.outboxpattern.mapper;

import com.ms.outboxpattern.dto.OrderRequestDto;
import com.ms.outboxpattern.entity.Order;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class OrderDtoToEntityMapper {

    public Order map(OrderRequestDto orderRequestDto){
        return Order.builder()
                .customerId(orderRequestDto.getCustomerId())
                .name(orderRequestDto.getName())
                .productType(orderRequestDto.getProductType())
                .price(orderRequestDto.getPrice())
                .quantity(orderRequestDto.getQuantity())
                .orderDate(new Date())
                .build();
    }
}
