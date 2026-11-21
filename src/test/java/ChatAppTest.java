import com.homework_10.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

public class ChatAppTest {
    ChatServer server = new ChatServer();

    User userOne = new User("Robin", server);
    User userTwo = new User("Demetrius", server);

    @Test
    public void testSendMessage() {
        userOne.sendMessage(Arrays.asList(userTwo), "Hello!");

        int expected = 1;
        int actual = userTwo.getChatHistory().getMessages().size();

        assertEquals(expected, actual);
    }

}
