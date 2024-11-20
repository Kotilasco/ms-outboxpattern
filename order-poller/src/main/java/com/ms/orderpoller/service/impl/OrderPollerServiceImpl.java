package com.ms.orderpoller.service.impl;

import com.ms.orderpoller.entity.OrderOutbox;
import com.ms.orderpoller.publisher.MessagePublisher;
import com.ms.orderpoller.repository.OrderOutboxRepository;
import com.ms.orderpoller.service.OrderPollerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@EnableScheduling
@Slf4j
public class OrderPollerServiceImpl implements OrderPollerService {

    private final OrderOutboxRepository orderOutboxRepository;

    private final MessagePublisher messagePublisher;

    @Override
    @Scheduled(fixedRate = 60000)
    public void pollOutboxMessagesAndPublish() {
        //1. fetch unprocessed
        List<OrderOutbox> unprocessedRecords = orderOutboxRepository.findByProcessedFalse();
        log.info("unprocessed record count:: "+ unprocessedRecords.size());
        //2. publish record to kafka
        unprocessedRecords.forEach(outbox -> {
            try{
                messagePublisher.publish(outbox.getPayload());
                // update the message status to processed=true to avoid duplicate messages
                outbox.setProcessed(true);
                orderOutboxRepository.save(outbox);
            }catch (Exception e){
                log.error(e.getMessage());
            }
        });

    }
}
