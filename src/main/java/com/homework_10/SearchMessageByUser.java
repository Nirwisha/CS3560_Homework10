package com.homework_10;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class SearchMessageByUser implements Iterator<Message> {
    private List<Message> messages;
    private User userToSearchWith;
    private int indexInMessageCollection;
    private int messageCollectionSize;

    public SearchMessageByUser(ChatHistory chatHistory, User userToSearchWith) {
        this.messages = chatHistory.getMessages();
        this.userToSearchWith = userToSearchWith;
        this.indexInMessageCollection = 0;
        this.messageCollectionSize = messages.size();
    }

    public boolean hasNext() {
        while (indexInMessageCollection < messageCollectionSize) {
            Message message = messages.get(indexInMessageCollection);

            boolean isSentByUser = message.getSender() == userToSearchWith;
            boolean isSentToUser = message.getRecipients().contains(userToSearchWith);

            if (isSentByUser || isSentToUser) {
                return true;
            }

            indexInMessageCollection++;
        }

        return false;
    }

    public Message next() {
        if (hasNext()) {
            return messages.get(indexInMessageCollection++);
        }

        throw new NoSuchElementException();
    }
}
