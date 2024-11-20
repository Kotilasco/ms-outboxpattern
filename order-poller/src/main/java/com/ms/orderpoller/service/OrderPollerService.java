package com.ms.orderpoller.service;


public interface OrderPollerService {

    void pollOutboxMessagesAndPublish();
}
