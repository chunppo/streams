package com.chunppo.streams.message;

public interface MessagePublisher {
    void publish(String qu, final String message);
}
