package field_validator.string_validator_predicate.main;

import field_validator.string_validator_predicate.PredicateStringRules;
import field_validator.string_validator_predicate.PredicateStringValidator;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main_PredicateStringValidator {

    public static void main(String[] args) {

        Map<String, String> test = new LinkedHashMap<>();
        test.put("null", null);
        test.put("empty", "");
        test.put("Hi", "Hi");
        test.put("123", "123");
        test.put("123456", "123456");
        test.put("12ab", "12ab");

        PredicateStringValidator validator = new PredicateStringValidator();
        validator.setRequired(true);
        validator.addRule(PredicateStringRules.maxLength(5), "maximum " + 5 + " zeichen");
        validator.addRule(PredicateStringRules.minLength(2), "mindestens " + 2 + " zeichen");
        validator.addRule(PredicateStringRules.onlyDigits(), "nur Ziffern");

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