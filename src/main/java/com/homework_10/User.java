package com.homework_10;

import java.util.List;

// methods to send messages to other users, recieve messages, and undo last msg (not communicating directly)
public class User {
    private String name;
    private ChatServer server;
    private ChatHistory history;

    public User(String name, ChatServer server) {
        this.name = name;
        this.server = server;
        this.history = new ChatHistory();
        server.registerUser(this);
    }

    public String getName() {
        return name;
    }

    public void sendMessage(List<User> recipients, String content) {
        Message message = new Message(this, recipients, content);

        history.addMessage(message);
        server.sendMessage(message);
    }

    public void receiveMessage(Message message) {
        history.addMessage(message);

        System.out.println(message.getSender().getName() + " sent message to " + name + ": " + message.getContent());
    }

    public ChatHistory getChatHistory() {
        return history;
    }
 
}