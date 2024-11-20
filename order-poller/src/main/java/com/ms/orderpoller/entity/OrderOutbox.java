package com.ms.orderpoller.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "Order_Outbox")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderOutbox {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String aggregateId;
    private String payload;
    private Date createdAt;
    private Boolean processed;
}
