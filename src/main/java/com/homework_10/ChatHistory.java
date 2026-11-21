package com.homework_10;

import java.util.ArrayList;
import java.util.List;

// stores chat history, add new msg to history and get last msg sent
public class ChatHistory {
    private List<Message> messages;

    public ChatHistory() {
        messages = new ArrayList<>();
    }

    public void addMessage(Message message) {
        messages.add(message);
    }

    public Message getLastMessageSent(User user) {
        for (int i = messages.size() - 1; i >= 0; i--) {
            Message message = messages.get(i);

            if (message.getSender() == user) {
                return message;
            }
        }

        return null;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void removeMessage(Message message) {
        messages.remove(message);
    }

    public void printHistory() {
        if (messages.isEmpty()) {
            System.out.println("No messages in chat history.");
            return;
        }

        for (Message message : messages) {
            System.out.println(message.getSender().getName() + ": " + message.getContent());
        }
    }
}
