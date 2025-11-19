package lesson_12_functional_interfaces.builder;

public class MessageBuilder {

    private String subject;

    private String body;

    private MessageBuilder() {
        //
    }

    public static MessageBuilder create() {
        return new MessageBuilder();
    }

    public MessageBuilder subject(String s) {
        subject = s;
        return this;
    }

    public MessageBuilder body(String b) {
        body = b;
        return this;
    }

    public Message build() {
        return new Message(subject, body);
    }
}
