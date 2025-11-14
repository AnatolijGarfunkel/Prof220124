package lesson_12_functional_interfaces;

import java.util.*;

public class FieldValidatorTester {

    static final String ERR_VALIDATORS_NULL = "Validator-Liste ist null";
    static final String ERR_VALIDATORS_EMPTY = "Validator-Liste ist empty";
    static final String ERR_VALIDATOR_NULL  = "Validator ist null";
    static final String ERR_FIELD_NULL      = "Feld ist null";
    record PrecheckResult(boolean valid, List<String> messages) {}


    public static void main(String[] args) {
        Map<String, List<FieldValidator>> rules = new HashMap<>();

        FieldValidator notNull = text -> text == null ? Optional.of(ERR_FIELD_NULL) : Optional.empty();
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
//        passRules.add(null);

        Map<String, List<FieldValidator>> fieldRules = new LinkedHashMap<>(
                Map.of(
                        "name", nameRules,
                        "email", emailRules,
                        "password", passRules
                )
        );

        Map<String, String> data = new HashMap<>();
        data.put("name", null);
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
        Map<String, List<String>> log = new LinkedHashMap<>();

        for (Map.Entry<String, String> pair : data.entrySet()) {
            String key = pair.getKey();

            if (key == null) continue;

            List<String> entries = new ArrayList<>();
            List<FieldValidator> validators = rules.get(key);
            String value = pair.getValue();

            precheckField(value, validators);
            if (!precheckResult.valid()) {
                log.put(key, precheckResult.messages());
                continue;
            }

            for (FieldValidator validator : validators) {
                Optional<String> result = validator == null ? Optional.of(ERR_VALIDATOR_NULL) : validator.validate(value);
                result.ifPresent(entries::add);
            }

            log.put(key, entries);
        }
        return log;
    }

    private static Optional<ValidationResult> precheckField(
            String fieldName,
            String value,
            List<FieldValidator> validators
    ) {
        if (value == null) {
            return Optional.of(
                    new ValidationResult(
                            fieldName,
                            ValidationStatus.FIELD_NULL,
                            "Feld '" + fieldName + "' ist null"
                    )
            );
        }

        if (validators == null) {
            return Optional.of(
                    new ValidationResult(
                            fieldName,
                            ValidationStatus.VALIDATORS_NULL,
                            "Keine Validator-Liste für feld '" + fieldName + "'"
                    )
            );
        }

        if (validators.isEmpty()) {
            return Optional.of(
                    new ValidationResult(
                            fieldName,
                            ValidationStatus.VALIDATORS_EMPTY,
                            "Validator-Liste für Feld '" + fieldName + "' ist leer"
                    )
            );
        }

        return Optional.empty();
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















































