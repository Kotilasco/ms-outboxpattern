package com.ms.outboxpattern.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ms.outboxpattern.dto.OrderRequestDto;
import com.ms.outboxpattern.entity.Order;

public interface OrderService {

Order createOrder(OrderRequestDto request) throws JsonProcessingException;
}
