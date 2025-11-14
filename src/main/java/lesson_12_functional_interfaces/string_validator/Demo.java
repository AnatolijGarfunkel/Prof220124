package lesson_12_functional_interfaces.string_validator;

import java.util.List;

public class Demo {

    public static void main(String[] args) {

        StringValidator validator = new StringValidator();

        validator.addRule(StringRules.notNull());
        validator.addRule(StringRules.notEmpty());
        validator.addRule(StringRules.minLength(3));

        List<String> errors = validator.validate("Hi");

        if (errors.isEmpty())
            System.out.println("String ist gültig");
        else {
            System.out.println("Fehler");
            errors.forEach(System.out::println);
        }
    }
}
