package lesson_12_functional_interfaces;

import java.util.*;

public class FieldValidatorTester {

    static Map<String, String> nullMessages = Map.of(
            "name", "Name darf nicht leer sein",
            "email", "E-Mail fehlt",
            "password", "Passwort ist erforderlich"
    );

    public static void main(String[] args) {
        Map<String, List<FieldValidator>> rules = new HashMap<>();

        FieldValidator notNull = text -> text == null ? Optional.of("Fehler - ist Null") : Optional.empty();
        FieldValidator notEmpty = text -> !text.isEmpty() ? Optional.empty() : Optional.of("Fehler - darf nicht leer sein");
        FieldValidator minLength = minLengthN(5);
        FieldValidator maxLength = maxLengthN(10);
        FieldValidator containsAtSign = email -> email.contains("@") ? Optional.empty() : Optional.of("Fehler - enthält kein @ Zeichen");
        FieldValidator containsDotAfterAt = email -> email.contains("@.") ? Optional.of("Fehler - nach \"@\" existiert ein \".\"") : Optional.empty();
        FieldValidator hasDigit = value -> {
            char[] chars = value.toCharArray();
            for (char c : chars) {
                if (Character.isDigit(c))
                    return Optional.empty();
            }
            return Optional.of("Fehler - enthält keine Ziffer");
        };
        FieldValidator hasUppercase = pass -> {
            char[] chars = pass.toCharArray();
            for (char c : chars)
                if (Character.isUpperCase(c))
                    return Optional.empty();
            return Optional.of("Fehler - keine Buchstaben im oberen Register");
        };
        FieldValidator startsWithUppercase = name -> Character.isUpperCase(name.charAt(0)) ? Optional.empty() : Optional.of("Fehler - fängt klein an");
        FieldValidator lettersOnly = name -> {
            char[] chars = name.toCharArray();
            for (char c : chars)
                if (Character.isDigit(c))
                    return Optional.of("Fehler - enthält Ziffern");
            return Optional.empty();
        };

        List<FieldValidator> nameRules = List.of(
                notNull,
                notEmpty,
                minLength,
                maxLength,
                startsWithUppercase,
                lettersOnly
        );

        List<FieldValidator> emailRules = List.of(
                notNull,
                notEmpty,
                containsAtSign,
                containsDotAfterAt
        );

        List<FieldValidator> passRules = new ArrayList<>(List.of(
                notNull,
                notEmpty,
                hasDigit
        ));
        passRules.add(null);

        Map<String, List<FieldValidator>> fieldRules = new HashMap<>(
                Map.of(
                        "name", nameRules,
                        "email", emailRules,
                        "password", passRules
                )
        );

        Map<String, String> data = new HashMap<>();
        data.put("name", "Marcus");
        data.put("email", "marcus@email.de");
        data.put("password", "marcus23");

        Map<String, List<String>> validated = validateAllFields(data, fieldRules);
        System.out.println(validated);

    }

    private static FieldValidator maxLengthN(int max) {
        return text -> text.length() <= max ? Optional.empty() : Optional.of("Fehler - max. " + max + " Zeichen");
    }

    private static FieldValidator minLengthN(int min) {
        return text -> text.length() >= min ? Optional.empty() : Optional.of("Fehler - mind. " + min + " Zeichen");
    }

    public static List<String> validateField(String value, List<FieldValidator> validators) {
        List<String> errors = new ArrayList<>();

        for (FieldValidator validator : validators) {
            Optional<String> optional = validator.validate(value);
            optional.ifPresent(errors::add);
        }

        return errors;
    }

    public static Map<String, List<String>> validateAllFields(Map<String, String> data, Map<String, List<FieldValidator>> rules) {
        Map<String, List<String>> log = new HashMap<>();

        for (Map.Entry<String, String> pair : data.entrySet()) {
            String key = pair.getKey();
            String value = pair.getValue();
            List<FieldValidator> validators = rules.get(key);
            List<String> entries = new ArrayList<>();

            for (FieldValidator validator : validators) {
                String messageOnNull = nullMessages.getOrDefault(key, key + " ist null");
                FieldValidator safedValidate = FieldValidator.safeValidate(validator, messageOnNull);
                Optional<String> result = safedValidate.validate(value);
                result.ifPresent(entries::add);
            }

            log.put(key, entries);
        }
        return log;
    }

    public static Map<String, Optional<String>> validateFirstErrorPerField(Map<String, String> data, Map<String, List<FieldValidator>> rules) {
        Map<String, Optional<String>> log = new HashMap<>();

        for (Map.Entry<String, String> pair : data.entrySet()) {
            String key = pair.getKey();
            String value = pair.getValue();
            List<FieldValidator> validators = rules.get(key);

            for (FieldValidator validator : validators) {
                Optional<String> optional = validator.validate(value);
                if (optional.isPresent()) {
                    log.put(key, optional);
                    break;
                }
            }
        }

        return log;
    }

    public static boolean isFormValid(Map<String, String> data, Map<String, List<FieldValidator>> rules) {

        for (Map.Entry<String, String> pair : data.entrySet()) {
            String key = pair.getKey();
            String value = pair.getValue();
            List<FieldValidator> validators = rules.get(key);

            for (FieldValidator validator : validators) {
                Optional<String> result = validator.validate(value);
                if (result.isPresent())
                    return false;
            }
        }

        return true;
    }

    public static FieldValidator combine(List<FieldValidator> validators) {
        return value -> {
            for (FieldValidator validator : validators) {
                Optional<String> result = validator.validate(value);
                if (result.isPresent())
                    return result;
            }
            return Optional.empty();
        };
    }

    public static FieldValidator nullSafe(FieldValidator original, String messageOnNull) {
        return value -> value == null ? Optional.of(messageOnNull) : original.validate(value);
    }
}















































