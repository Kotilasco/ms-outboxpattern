package com.ms.outboxpattern.repository;

import com.ms.outboxpattern.entity.OrderOutbox;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderOutboxRepository extends JpaRepository<OrderOutbox, Long> {
}
