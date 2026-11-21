package com.homework_10;

import java.util.List;

// methods to send messages to other users, recieve messages, and undo last msg (not communicating directly)
public class User {
    private String name;
    private ChatServer server;
    private ChatHistory history;
    private Message lastSentMessage;
    private MessageMemento memento;

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

        lastSentMessage = message;

        saveMessage();

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

    public void saveMessage() {
        if (lastSentMessage != null) {
            memento = new MessageMemento(lastSentMessage);
        }
    }

    public void undoLastMessage() {
        if (lastSentMessage == null) {
            System.out.println("There is no message to undo.\n");
            return;
        }

        Message messageToRemove = memento.getSavedMessage();

        server.removeMessageFromHistory(messageToRemove);

        System.out.println(name + " undid their last message: " + memento.getContent());

        lastSentMessage = null;
        memento = null;
    }
 
}