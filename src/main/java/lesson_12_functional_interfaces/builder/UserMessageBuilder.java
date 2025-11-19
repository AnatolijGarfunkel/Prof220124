package lesson_12_functional_interfaces.builder;

import java.util.function.Consumer;

public class UserMessageBuilder {

    private final UserBuilder userBuilder = UserBuilder.create();

    private final MessageBuilder messageBuilder = MessageBuilder.create();

    private UserMessageBuilder() {
        //
    }

    public static UserMessageBuilder create() {
        return new UserMessageBuilder();
    }


    public UserMessageBuilder configureUser(Consumer<UserBuilder> consumer) {
        consumer.accept(userBuilder);
        return this;
    }

    public UserMessageBuilder configureMessage(Consumer<MessageBuilder> consumer) {
        consumer.accept(messageBuilder);
        return this;
    }

    public UserMessage build() {
        User user = userBuilder.build();
        Message message = messageBuilder.build();
        return new UserMessage(user, message);
    }
}
