package com.ms.outboxpattern.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.outboxpattern.entity.Order;
import com.ms.outboxpattern.entity.OrderOutbox;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class OrderEntityToOutboxMapper {

    public OrderOutbox map(Order order) throws JsonProcessingException {
    return OrderOutbox.builder()
                .aggregateId(order.getId().toString())
                .payload(new ObjectMapper().writeValueAsString(order))
                .processed(false)
                .createdAt(new Date())
                .build();
    }
}
