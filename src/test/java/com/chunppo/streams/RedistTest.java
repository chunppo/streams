package com.chunppo.streams;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@SpringBootTest
public class RedistTest {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private MessageListenerAdapter messageListenerAdapter;

    @Autowired
    private RedisMessageListenerContainer redisContainer;

    @Test
    public void send() {
        System.out.println("TEST");
//        redisContainer.
//        redisContainer.addMessageListener(messageListenerAdapter, new ChannelTopic("chunppo"));

//        redisTemplate.convertAndSend("pubsub:allNumber", "1000:last");

//        redisMessagePublisher.publish("queue", message);
    }

}
