public class AIMessage extends Message {
    private static final String DEFAULT_BODY = "Hello! This is a very intelligent response to your message :P";
    public AIMessage() {
        super(DEFAULT_BODY, true);
    }

    @Override
    public void print() {
        System.out.println("Your intelligent teacher responded:");
        super.print();
    }
}
