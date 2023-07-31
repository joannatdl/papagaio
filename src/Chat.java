import java.util.ArrayList;

public class Chat {
    private User user;
    private ArrayList<Message> messages;

    public Chat(Message message) {
        this.user = new User();
        this.messages = new ArrayList<Message>();
        this.messages.add(message);
    }

    public void sendResponse() {
        System.out.println("Hello! This is a very intelligent response to your message :P");
    }
}
