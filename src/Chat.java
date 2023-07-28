public class Chat {
    private User user;
    private Message[] messages;

    public Chat(Message message) {
        this.user = new User();
        this.messages = new Message[] { message };
    }

    public void sendResponse() {
        System.out.println("Hello! This is a very intelligent response to your message :P");
    }
}
