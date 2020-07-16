package com.chunppo.streams.config;

import com.chunppo.streams.message.MessagePublisher;
import com.chunppo.streams.message.RedisMessagePublisher;
import com.chunppo.streams.message.RedisMessageSubscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.messaging.core.MessageSendingOperations;

@Configuration
public class RedisConfig {

    @Autowired
    private MessageSendingOperations<String> messagingTemplate;

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory(new RedisStandaloneConfiguration("localhost", 6379));
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        final RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
        return template;
    }
//
//    @Bean
//    public MessageListenerAdapter countMessageListener() {
//        return new MessageListenerAdapter(new RedisCountMessageSubscriber(messagingTemplate));
//    }

    @Bean
    public MessageListenerAdapter messageListener() {
        return new MessageListenerAdapter(new RedisMessageSubscriber(messagingTemplate));
    }

    @Bean
    public RedisMessageListenerContainer redisContainer() {
        final RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(jedisConnectionFactory());
//        container.addMessageListener(countMessageListener(), countTopic());
//        container.addMessageListener(messageListener(), topic());
        return container;
    }

//    @Bean
//    public MessagePublisher redisCountPublisher() {
//        return new RedisCountMessagePublisher(redisTemplate(), countTopic());
//    }

    @Bean
    public MessagePublisher redisPublisher() {
        return new RedisMessagePublisher(redisTemplate(), topic());
    }

    @Bean
    ChannelTopic countTopic() {
        return new ChannelTopic("pubsub:count");
    }

    @Bean
    ChannelTopic topic() {
        return new ChannelTopic("pubsub:queue");
    }
}
