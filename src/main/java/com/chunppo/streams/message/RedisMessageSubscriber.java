package com.chunppo.streams.message;

import com.chunppo.streams.model.ChatMessage;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.messaging.core.MessageSendingOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class RedisMessageSubscriber implements MessageListener {
    private MessageSendingOperations<String> messagingTemplate;

    public static List<String> messageList = new ArrayList<>();

    public void onMessage(final Message message, final byte[] pattern) {
        System.out.println(message);
        System.out.println(message.toString().split(":")[0]);
        messageList.add(message.toString());
        messagingTemplate.convertAndSend("/topic/subscribe/" + message.toString().split(":")[0].trim(), new ChatMessage(RedisMessageSubscriber.lastMessage().get()));
    }

    public static Optional<String> lastMessage() {
        if (messageList.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(messageList.get(messageList.size() - 1));
    }
}
