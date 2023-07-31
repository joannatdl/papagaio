public class Message {
    private String body;
    private Boolean sendByAI;

    public Message(String body, Boolean sendByAI) {
        this.body = body;
        this.sendByAI = sendByAI;
    }

    public void print() {
        System.out.println(body);
    }
}
