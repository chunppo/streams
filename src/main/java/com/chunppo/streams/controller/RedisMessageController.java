package com.chunppo.streams.controller;

import com.chunppo.streams.message.RedisMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisMessageController {
    @Autowired
    private RedisMessagePublisher redisMessagePublisher;

    @Autowired
    private MessageListenerAdapter messageListenerAdapter;

    @Autowired
    private RedisMessageListenerContainer redisContainer;

//    @Autowired
//    private RedisCountMessagePublisher redisCountMessagePublisher;

    @MessageMapping("/sendMessage")
    public void sendMessage(String message) throws Exception {
        redisMessagePublisher.publish("queue", message);
    }

    @GetMapping("/http/sendMessage")
    public void httpSendMessage(@RequestParam String message) throws Exception {
        redisContainer.addMessageListener(messageListenerAdapter, new ChannelTopic("pubsub:queue"));
        redisMessagePublisher.publish("queue", message);
    }

    @GetMapping("/allNumber")
    public void allNumber(@RequestParam String message) throws Exception {
        redisContainer.addMessageListener(messageListenerAdapter, new ChannelTopic("pubsub:allNumber"));
        redisMessagePublisher.publish("allNumber", message);
    }

//    @GetMapping("/http/sendMessage/count")
//    public void httpSendMessage() throws Exception {
//        redisCountMessagePublisher.publish("sdfsdfsd");
//    }
}
