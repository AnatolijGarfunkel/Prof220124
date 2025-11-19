package lesson_12_functional_interfaces.first_task;

import java.util.*;

public class FT_FieldValidatorTester {

    static final String ERR_FIELD_NULL = "Feld ist null";


    public static void main(String[] args) {
        Map<String, List<FT_FieldValidator>> rules = new HashMap<>();

        FT_FieldValidator notEmpty = text -> !text.isEmpty() ? Optional.empty() : Optional.of("Fehler - darf nicht leer sein");
        FT_FieldValidator minLength = minLengthN(5);
        FT_FieldValidator maxLength = maxLengthN(10);
        FT_FieldValidator containsAtSign = email -> email.contains("@") ? Optional.empty() : Optional.of("Fehler - enthält kein @ Zeichen");
        FT_FieldValidator containsDotAfterAt = email -> email.contains("@.") ? Optional.of("Fehler - nach \"@\" existiert ein \".\"") : Optional.empty();
        FT_FieldValidator hasDigit = value -> {
            char[] chars = value.toCharArray();
            for (char c : chars) {
                if (Character.isDigit(c))
                    return Optional.empty();
            }
            return Optional.of("Fehler - enthält keine Ziffer");
        };
        FT_FieldValidator hasUppercase = pass -> {
            char[] chars = pass.toCharArray();
            for (char c : chars)
                if (Character.isUpperCase(c))
                    return Optional.empty();
            return Optional.of("Fehler - keine Buchstaben im oberen Register");
        };
        FT_FieldValidator startsWithUppercase = name -> Character.isUpperCase(name.charAt(0)) ? Optional.empty() : Optional.of("Fehler - fängt klein an");
        FT_FieldValidator lettersOnly = name -> {
            char[] chars = name.toCharArray();
            for (char c : chars)
                if (Character.isDigit(c))
                    return Optional.of("Fehler - enthält Ziffern");
            return Optional.empty();
        };

        List<FT_FieldValidator> nameRules = List.of(
                notEmpty,
                minLength,
                maxLength,
                startsWithUppercase,
                lettersOnly
        );

        List<FT_FieldValidator> emailRules = List.of(
                notEmpty,
                containsAtSign,
                containsDotAfterAt
        );

        List<FT_FieldValidator> passRules = new ArrayList<>(List.of(
                notEmpty,
                hasDigit
        ));

        Map<String, List<FT_FieldValidator>> fieldRules = new LinkedHashMap<>(
                Map.of(
                        "name", nameRules,
                        "email", emailRules,
                        "password", passRules
                )
        );

        Map<String, String> data = new HashMap<>();
        data.put("name", null);
        data.put(null, "marcusemail.de");
        data.put("password", "marcus23");

        Map<String, List<FT_ValidationResult>> validated = validateAllFields(data, fieldRules);
        System.out.println(validated);

    }

    private static FT_FieldValidator maxLengthN(int max) {
        return text -> text.length() <= max ? Optional.empty() : Optional.of("Fehler - max. " + max + " Zeichen");
    }

    private static FT_FieldValidator minLengthN(int min) {
        return text -> text.length() >= min ? Optional.empty() : Optional.of("Fehler - mind. " + min + " Zeichen");
    }

    public static List<FT_ValidationResult> validateField(String value, List<FT_FieldValidator> validators) {
        List<FT_ValidationResult> errors = new ArrayList<>();
        String key = "key";

        Optional<FT_ValidationResult> precheckField = precheckField(key, value, validators);
        if (precheckField.isPresent()) {
            errors.add(precheckField.get());
            return errors;
        }

        for (FT_FieldValidator validator : validators) {
            if (validator == null) {
                errors.add(new FT_ValidationResult(
                        key,
                        FT_ValidationStatus.VALIDATOR_NULL,
                        "Ein Validator für Schlüssel '" + key + "' ist null"
                ));
                continue;
            }

            Optional<String> message = validator.validate(value);
            message.ifPresent(string -> errors.add(
                    new FT_ValidationResult(
                            key,
                            FT_ValidationStatus.RULE_VIOLATION,
                            string

                    )
            ));
        }

        return errors;
    }

    public static Map<String, List<FT_ValidationResult>> validateAllFields(Map<String, String> data, Map<String, List<FT_FieldValidator>> rules) {
        Map<String, List<FT_ValidationResult>> log = new LinkedHashMap<>();
        List<FT_ValidationResult> FTValidationResults = new ArrayList<>();

        for (Map.Entry<String, String> pair : data.entrySet()) {
            String key = pair.getKey();

            if (key == null) {
                FTValidationResults.add(new FT_ValidationResult(
                        "Schlüssel",
                        FT_ValidationStatus.KEY_NULL,
                        "Schlüssel ist null"
                ));
                continue;
            }

            List<FT_FieldValidator> validators = rules.get(key);
            String value = pair.getValue();

            FTValidationResults.addAll(validateField(value, validators));
            log.put(key, FTValidationResults);
        }

        return log;
    }

    private static Optional<FT_ValidationResult> precheckField(
            String key,
            String value,
            List<FT_FieldValidator> validators
    ) {
        if (value == null) {
            return Optional.of(
                    new FT_ValidationResult(
                            key,
                            FT_ValidationStatus.FIELD_NULL,
                            "Schlüssel '" + key + "' ist null"
                    )
            );
        }

        if (validators == null) {
            return Optional.of(
                    new FT_ValidationResult(
                            key,
                            FT_ValidationStatus.VALIDATORS_NULL,
                            "Keine Validator-Liste für Schlüssel '" + key + "'"
                    )
            );
        }

        if (validators.isEmpty()) {
            return Optional.of(
                    new FT_ValidationResult(
                            key,
                            FT_ValidationStatus.VALIDATORS_EMPTY,
                            "Validator-Liste für Schlüssel '" + key + "' ist leer"
                    )
            );
        }

        return Optional.empty();
    }

    public static Map<String, FT_ValidationResult> validateFirstErrorPerField(Map<String, String> data, Map<String, List<FT_FieldValidator>> rules) {
        Map<String, FT_ValidationResult> log = new LinkedHashMap<>();

        for (Map.Entry<String, String> pair : data.entrySet()) {
            String key = pair.getKey();

            if (key == null) {
                log.put("NULL-Schlüssel",
                        new FT_ValidationResult(
                                "Schlüssel",
                                FT_ValidationStatus.KEY_NULL,
                                "Schlüssel ist null"
                        )
                );
                continue;
            }

            List<FT_FieldValidator> validators = rules.get(key);
            String value = pair.getValue();

            Optional<FT_ValidationResult> precheckField = precheckField(key, value, validators);
            if (precheckField.isPresent()) {
                log.put(key, precheckField.get());
                continue;
            }

            for (FT_FieldValidator validator : validators) {
                if (validator == null) {
                    log.put(key,
                            new FT_ValidationResult(
                                    key,
                                    FT_ValidationStatus.VALIDATOR_NULL,
                                    "Ein Validator für Schlüssel '" + key + "' ist null"
                            ));
                    break;
                }

                Optional<String> message = validator.validate(value);
                if (message.isPresent()) {
                    log.put(key,
                            new FT_ValidationResult(
                            key, FT_ValidationStatus.RULE_VIOLATION, message.get())
                    );
                    break;
                }
            }
        }
        return log;
    }

    public static boolean isFormValid(Map<String, String> data, Map<String, List<FT_FieldValidator>> rules) {

        for (Map.Entry<String, String> pair : data.entrySet()) {
            String key = pair.getKey();
            String value = pair.getValue();
            List<FT_FieldValidator> validators = rules.get(key);

            for (FT_FieldValidator validator : validators) {
                Optional<String> result = validator.validate(value);
                if (result.isPresent())
                    return false;
            }
        }

        return true;
    }

    public static FT_FieldValidator combine(List<FT_FieldValidator> validators) {
        return value -> {
            for (FT_FieldValidator validator : validators) {
                Optional<String> result = validator.validate(value);
                if (result.isPresent())
                    return result;
            }
            return Optional.empty();
        };
    }

    public static FT_FieldValidator nullSafe(FT_FieldValidator original, String messageOnNull) {
        return value -> value == null ? Optional.of(messageOnNull) : original.validate(value);
    }
}















































