package com.homework_10;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// propersites for sender, recipients, timestamp, and message content
public class Message {
    private User sender;
    private List<User> recipients;
    private LocalDateTime timestamp;
    private String content;

    public Message(User sender, List<User> recipients, String content) {
        this.sender = sender;
        this.recipients = new ArrayList<>(recipients);
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }

    public User getSender() {
        return sender;
    }

    public List<User> getRecipients() {
        return recipients;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getContent() {
        return  content;
    }
}