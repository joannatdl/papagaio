public class UserMessage extends Message {
    private User sender;

    public UserMessage(String body) {
        super(body, false);
        this.sender = new User();
    }
}
