package field_validator.string_validator_function;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StringValidator_Main {

    public static void main(String[] args) {

        Map<String, String> test = new LinkedHashMap<>();
        test.put("null", null);
        test.put("empty", "");
        test.put("Hi", "Hi");
        test.put("123", "123");
        test.put("123456", "123456");
        test.put("12ab", "12ab");

        StringValidator validator = new StringValidator();
        validator.addRule(StringRules.beginsWithUp());
        validator.addRule(StringRules.maxLength(5));
        validator.addRule(StringRules.minLength(2));
        validator.addRule(StringRules.onlyDigits());
        validator.addRule(StringRules.maxAge(130));

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
