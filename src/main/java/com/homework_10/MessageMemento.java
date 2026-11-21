package com.homework_10;

import java.time.LocalDateTime;

// properties of msg content and timestamp
public class MessageMemento {
    private String content;
    private LocalDateTime timestamp;
    private Message messageState;

    public MessageMemento(Message message) {
        this.messageState = message;
        this.content = message.getContent();
        this.timestamp = message.getTimestamp();
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Message getSavedMessage() {
        return messageState;
    }
}