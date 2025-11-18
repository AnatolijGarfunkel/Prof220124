package lesson_12_functional_interfaces.builder;

public class Demo {

    public static void main(String[] args) {

        UserMessage userMessage = UserMessageBuilder.create()
                .configureUser(u -> u
                        .name("Marcus")
                        .email("marcus@email.com"))
                .configureMessage(m -> m
                        .subject("Gruß")
                        .body("Gruß aus Dortmund"))
                .build();

        System.out.println("User: " + userMessage.user());
        System.out.println("Message " + userMessage.message());
    }
}
