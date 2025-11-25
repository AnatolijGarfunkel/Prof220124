package field_validator.string_validator;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static field_validator.string_validator.StringRules.onlyDigits;

public class StringValidatorBuilder_Main {

    public static void main(String[] args) {

        Map<String, String> test = new LinkedHashMap<>();
        test.put("null", null);
        test.put("empty", "");
        test.put("Hi", "Hi");
        test.put("123", "123");
        test.put("123456", "123456");
        test.put("12ab", "12ab");

        int length = 2;
        int max = 5;
        int age = 130;

        StringValidator validator = StringValidatorBuilder.create()
                .configure(value -> !value.chars().allMatch(Character::isDigit) ? "Wert darf nur Ziffern enthalten." : null)
                .configure(value -> value.length() < length ? "Wert muss mindestens " + length + " Zeichen lang sein." : null)
                .configure(value -> value.length() > max ? "Wert darf höchstens " + max + " Zeichen lang sein." : null)
                .configure(value -> {
                    if (onlyDigits().validateString(value) == null) {
                        return Integer.parseInt(value) < 0 || Integer.parseInt(value) > age ? "Wert liegt nicht im Bereich zw. 0 und " + age : null;
                    }
                    return "Wert lässt sich nicht in ein Integer umwandeln";
                })
                .beginsWithUp()
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
