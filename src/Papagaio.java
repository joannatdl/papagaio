public class Papagaio {

    //  To run this from command line run:
    //  java -cp .\out\production\Papagaio Papagaio how are you?
    public static void main(String... args) {
        String messageBody = String.join(" ", args);
        UserMessage userMessage = new UserMessage(messageBody);
        Chat chat = new Chat(userMessage);
        chat.sendResponse();
    }
}
