package com.ms.outboxpattern.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ms.outboxpattern.entity.OrderOutbox;
import com.ms.outboxpattern.mapper.OrderDtoToEntityMapper;
import com.ms.outboxpattern.dto.OrderRequestDto;
import com.ms.outboxpattern.entity.Order;
import com.ms.outboxpattern.mapper.OrderEntityToOutboxMapper;
import com.ms.outboxpattern.repository.OrderOutboxRepository;
import com.ms.outboxpattern.repository.OrderRepository;
import com.ms.outboxpattern.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderDtoToEntityMapper orderDtoToEntityMapper;
    private final OrderRepository orderRepository;
    private final OrderOutboxRepository orderOutboxRepository;
    private final OrderEntityToOutboxMapper orderEntityToOutboxMapper;

    @Override
    @Transactional
    public Order createOrder(OrderRequestDto request) throws JsonProcessingException {
Order order = orderDtoToEntityMapper.map(request);
order = orderRepository.save(order);

        OrderOutbox orderOutbox = orderEntityToOutboxMapper.map(order);
orderOutboxRepository.save(orderOutbox);
        return order;
    }
}
