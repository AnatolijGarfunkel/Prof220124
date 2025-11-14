package lesson_12_functional_interfaces.string_validator;

import java.util.List;

public class Demo {

    public static void main(String[] args) {

        StringValidator validator = new StringValidator();

        validator.addRule(StringRules.notNull());

        validator.addRule(StringRules.notEmpty());

        List errors = validator.validates("Hi");
    }
}
