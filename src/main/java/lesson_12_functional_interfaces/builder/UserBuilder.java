package lesson_12_functional_interfaces.builder;

public class UserBuilder {

    private String name;

    private String email;

    private UserBuilder() {
        //
    }

    public static UserBuilder create() {
        return new UserBuilder();
    }

    public UserBuilder name(String n) {
        name = n;
        return this;
    }

    public UserBuilder email(String e) {
        email = e;
        return this;
    }

    public User build() {
        return new User(name, email);
    }
}
