package field_validator.string_validator_function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class StringValidator {

    private final List<Function<String, String>> rules = new ArrayList<>();

    public void addRule(Function<String, String> rule) {
        rules.add(rule);
    }

    public List<String> validate(String value) {
        List<String> errors = new ArrayList<>();
        if (value == null) {
            errors.add("Wert darf nicht null sein.");
            return errors;
        }
        if (value.isEmpty()) {
            errors.add("Wert darf nicht leer sein");
            return errors;
        }

        for (Function<String, String> rule : rules) {
            String error = rule.apply(value);
            if (error != null)
                errors.add(error);
        }
        return errors;
    }
}
