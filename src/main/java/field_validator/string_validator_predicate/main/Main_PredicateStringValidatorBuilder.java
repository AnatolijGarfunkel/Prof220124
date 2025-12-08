package field_validator.string_validator_predicate.main;

import field_validator.string_validator_predicate.PredicateStringValidator;
import field_validator.string_validator_predicate.PredicateStringValidatorBuilder;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main_PredicateStringValidatorBuilder {
    public static void main(String[] args) {

        Map<String, String> test = new LinkedHashMap<>();
        test.put("null", null);
        test.put("empty", "");
        test.put("Hi", "Hi");
        test.put("123", "123");
        test.put("123456", "123456");
        test.put("12ab", "12ab");

        int min = 2;
        int max = 5;
        int age = 130;

        PredicateStringValidator validator = PredicateStringValidatorBuilder.create()
                .optional()
                .configure(value -> value.chars().allMatch(Character::isDigit),"Wert darf nur Ziffern enthalten.")
                .configure(value -> value.length() >= min, "Wert muss mindestens " + min + " Zeichen lang sein.")
                .configure(value -> value.length() <= max, "Wert darf höchstens " + max + " Zeichen lang sein.")
                .build();

        for (Map.Entry<String, String> pair : test.entrySet()) {
            String key = pair.getKey();
            String value = pair.getValue();
            List<String> errors = validator.validate(value);
            System.out.println("\nTest of value: " + key);
            if (errors.isEmpty())
                System.out.println("OK");
            else
                for (String error : errors)
                    System.out.println(error);
        }

    }
}
