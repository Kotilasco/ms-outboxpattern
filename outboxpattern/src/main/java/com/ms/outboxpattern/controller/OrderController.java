package com.ms.outboxpattern.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ms.outboxpattern.dto.OrderRequestDto;
import com.ms.outboxpattern.entity.Order;
import com.ms.outboxpattern.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    private Order createOrder(OrderRequestDto requestDto) throws JsonProcessingException {
        return orderService.createOrder(requestDto);
    }
}
