package com.ms.orderpoller.repository;

import com.ms.orderpoller.entity.OrderOutbox;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderOutboxRepository extends JpaRepository<OrderOutbox, Long> {

    List<OrderOutbox> findByProcessedFalse();
}
