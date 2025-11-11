package lesson_12_functional_interfaces;

import java.util.*;

public class FieldValidatorTester {

    public static void main(String[] args) {
        Map<String, String> data = new HashMap<>(
                Map.of(
                        "name", "mar",
                        "email", "marcusgmx.de",
                        "password", "marus89")
        );
        Map<String, List<FieldValidator>> rules = new HashMap<>();

        FieldValidator notEmpty = text -> !text.isEmpty() ? Optional.empty() : Optional.of("darf nicht leer sein");
        FieldValidator minLength = minLengthN(5);
        FieldValidator maxLength = maxLengthN(10);
        FieldValidator containsAtSign = email -> email.contains("@") ? Optional.empty() : Optional.of("enthält kein @ Zeichen");
        FieldValidator notContainsDotAfterAt = email -> email.contains("@.") ? Optional.empty() : Optional.of("nach \"@\" existiert ein \".\"");
        FieldValidator hasDigit = value -> {
            char[] chars = value.toCharArray();
            for (char c : chars) {
                if (Character.isDigit(c))
                    return Optional.empty();
            }
            return Optional.of("enthält keine Ziffern");
        };
        FieldValidator hasUppercase = pass -> {
            char[] chars = pass.toCharArray();
            for (char c : chars)
                if (Character.isUpperCase(c))
                    return Optional.empty();
            return Optional.of("erste Buchstabe im unteren Register");
        };
        FieldValidator notStartsWithUppercase = name -> !Character.isUpperCase(name.charAt(0)) ? Optional.empty() : Optional.of("fängt klein an");
        FieldValidator lettersOnly = name -> {
            char[] chars = name.toCharArray();
            for (char c : chars)
                if (Character.isDigit(c))
                    return Optional.of("enthält Ziffern");
            return Optional.empty();
        };

        List<FieldValidator> nameRules = List.of(
                notEmpty,
                minLength,
                maxLength,
                lettersOnly
        );

        List<FieldValidator> emailRules = List.of(
                notEmpty,
                containsAtSign,
                notContainsDotAfterAt
        );

        List<FieldValidator> passRules = List.of(
                notEmpty,
                hasDigit
        );

        Map<String, List<FieldValidator>> valueRules = new HashMap<>(
                Map.of(
                        "name", nameRules,
                        "email", emailRules,
                        "password", passRules
                )
        );

        Map<String, List<String>> validated = validateAllFields(data, valueRules);
        System.out.println(validated);

    }

    private static FieldValidator maxLengthN(int max) {
        return text -> text.length() <= max ? Optional.empty() : Optional.of("max. " + max + " Zeichen");
    }

    private static FieldValidator minLengthN(int min) {
        return text -> text.length() >= min ? Optional.empty() : Optional.of("mind. " + min + " Zeichen");
    }

    public static List<String> validateField(String value, List<FieldValidator> validators) {
        List<String> errors = new ArrayList<>();

        for (FieldValidator validator : validators) {
            Optional<String> optional = validator.validate(value);
            if (optional.isPresent())
                errors.add(String.valueOf(optional));
        }
        return errors;
    }

    public static Map<String, List<String>> validateAllFields(Map<String,String> data, Map<String, List<FieldValidator>> rules) {
        Map<String, List<String>> log = new HashMap<>();

        for (Map.Entry<String, String> pair : data.entrySet()) {
            String key = pair.getKey();
            List<FieldValidator> validators;
            List<String> entries;
            switch (key) {
                case "name":
                    validators = rules.get("name");
                    entries = new ArrayList<>();
                    for (FieldValidator validator : validators) {
                        String value = pair.getValue();
                        Optional<String> optional = validator.validate(value);
                        entries.add(String.valueOf(optional));
                    }
                    log.put(key, entries);
                    validators = null;
                    entries = null;
                    break;
                case "email":
                    validators = rules.get("email");
                    entries = new ArrayList<>();
                    for (FieldValidator validator : validators) {
                        String value = pair.getValue();
                        Optional<String> optional = validator.validate(value);
                        entries.add(String.valueOf(optional));
                    }
                    log.put(key, entries);
                    validators = null;
                    entries = null;
                    break;
                case "password":
                    validators = rules.get("password");
                    entries = new ArrayList<>();
                    for (FieldValidator validator : validators) {
                        String value = pair.getValue();
                        Optional<String> optional = validator.validate(value);
                        entries.add(String.valueOf(optional));
                    }
                    log.put(key, entries);
                    validators = null;
                    entries = null;
            }
        }

        return log;
    }

    public static Map<String, Optional<String>> validateFirstErrorPerField(Map<String, String> data, Map<String, List<FieldValidator>> rules) {

        return null;
    }

    public static boolean isFormValid(Map<String, String> data, Map<String, List<FieldValidator>> rules) {

        return false;
    }

    public static FieldValidator combine(List<FieldValidator> validators) {

        return null;
    }

    public static FieldValidator nullSafe(FieldValidator original, String messageOnNull) {
        return null;
    }
}
