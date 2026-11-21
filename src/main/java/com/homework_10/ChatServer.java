package com.homework_10;

import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// medidates communication between users (register & unregister, send msg and bock users)
public class ChatServer {
    private Map<String, User> users;
    private Map<User, Set<User>> blockedUsers;

    public ChatServer() {
        users = new HashMap<>();
        blockedUsers = new HashMap<>();
    }

    public void registerUser(User user) {
        users.put(user.getName(), user);
        blockedUsers.put(user, new HashSet<>());
    }

    public void unregisterUser(User user) {
        users.remove(user.getName());
        blockedUsers.remove(user);
    }

    public void sendMessage(Message message) {
        for (User recipient : message.getRecipients()) {
            Set<User> blockedSenders = blockedUsers.get(recipient);

            if (!blockedSenders.contains(message.getSender())) {
                recipient.receiveMessage(message);
            }
        }
    }

    public void removeMessageFromHistory(Message message) {
        for (User user : users.values()) {
            user.getChatHistory().removeMessage(message);
        }
    }

    public void blockUser(User receiver, User sender) {
        blockedUsers.get(receiver).add(sender);
    }

    public void unblockUser(User receiver, User sender) {
        blockedUsers.get(receiver).remove(sender);
    }
}
