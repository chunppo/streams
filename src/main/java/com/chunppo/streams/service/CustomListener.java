package com.chunppo.streams.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.core.MessageSendingOperations;
import org.springframework.stereotype.Service;

@Service
public class CustomListener {
    @Qualifier("brokerMessagingTemplate")
    @Autowired
    private MessageSendingOperations<String> messagingTemplate;


    @RabbitListener(queues = "topicQueue")
    public void receiveMessage(final Message message) {

        System.out.println("CustomerListener : " + message);

        messagingTemplate.convertAndSend("/topic/subscribe/chunppo", new String(message.getBody()));
    }
}
