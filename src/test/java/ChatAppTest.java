import com.homework_10.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Iterator;

public class ChatAppTest {
    ChatServer server = new ChatServer();

    User userOne = new User("Robin", server);
    User userTwo = new User("Demetrius", server);
    User userThree = new User("Linus", server);

    @Test
    public void testSendMessage() {
        userOne.sendMessage(Arrays.asList(userTwo), "Hello!");

        int expected = 1;
        int actual = userTwo.getChatHistory().getMessages().size();

        assertEquals(expected, actual);
    }

    @Test 
    public void testSendMessageToMultiUsers() {
        userOne.sendMessage(Arrays.asList(userTwo, userThree), "Hello everyone!");

        int expected = 1;
        int actualUser2 = userTwo.getChatHistory().getMessages().size();
        int actualUser3 = userThree.getChatHistory().getMessages().size();

        assertEquals(expected, actualUser2);
        assertEquals(expected, actualUser3);
    }

    @Test 
    public void testUndoMessage() {
        userOne.sendMessage(Arrays.asList(userTwo), "Will undo this message.");
        userOne.undoLastMessage();

        int expected = 0;
        int actual = userTwo.getChatHistory().getMessages().size();

        assertEquals(expected, actual);
    }

    @Test 
    public void testBlockMessage() {
        server.blockUser(userTwo, userOne);
        userOne.sendMessage(Arrays.asList(userTwo), "This message should be blocked");

        int expected = 0;
        int actual = userTwo.getChatHistory().getMessages().size();

        assertEquals(expected, actual);
    }

    @Test 
    public void testMemento() {
        Message message = new Message(userOne, Arrays.asList(userTwo), "Saved message");

        MessageMemento memento = new MessageMemento(message);
        
        String expected = "Saved message";
        String actual = memento.getContent();

        assertEquals(expected, actual);
    }

    @Test 
    public void testSearchMessage() {
        userOne.sendMessage(Arrays.asList(userTwo), "Hello!");
        userTwo.sendMessage(Arrays.asList(userOne), "Hello, Robin!");

        Iterator<Message> messages = userTwo.iterator(userOne);

        int actual = 0;

        while (messages.hasNext()) {
            messages.next();
            actual++;
        }

        int expected = 2;

        assertEquals(expected, actual);
    }

}
