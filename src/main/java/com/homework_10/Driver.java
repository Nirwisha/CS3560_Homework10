package com.homework_10;

import java.util.Arrays;

public class Driver {
    public static void main(String[] args) {
        ChatServer server = new ChatServer();

        User userOne = new User("Robin", server);
        User userTwo = new User("Demetrius", server);
        User userThree = new User("Linus", server);

        userOne.sendMessage(Arrays.asList(userTwo, userThree), "Hello!");
        userThree.sendMessage(Arrays.asList(userOne), "Hello Robin.");

        System.out.println("\nLinus' chat history: ");
        userThree.getChatHistory().printHistory();

        userOne.sendMessage(Arrays.asList(userTwo), "Did you bring the trash bin in?");
        server.blockUser(userTwo, userOne);

        userOne.sendMessage(Arrays.asList(userTwo), "Hello?");

        System.out.println("\nDemetrius' chat history after blocking Robin: ");
        userTwo.getChatHistory().printHistory();

    }
}
