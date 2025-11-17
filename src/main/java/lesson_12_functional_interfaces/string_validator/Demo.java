package lesson_12_functional_interfaces.string_validator;

import java.util.List;

public class Demo {

    public static void main(String[] args) {

        StringValidator validator = new StringValidator();

        validator.addRule(StringRules.minLength(3));
        validator.addRule(StringRules.onlyDigits());
        validator.addRule(StringRules.maxLength(5));

        List<String> tests = List.of(
                "",
                "Hi",
                "123",
                "123456",
                "12ab"
        );

        for (String s : tests) {
            System.out.println("Teste: " + s);
            List<String> errors = validator.validate(s);
            if (errors.isEmpty())
                System.out.println(" OK");
            else
                errors.forEach(System.out::println);
        }
    }
}
