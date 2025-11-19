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
        List<String> result = new ArrayList<>();
        if (value == null) {
            result.add("Wert darf nicht null sein.");
            return result;
        }
        if (value.isEmpty()) {
            result.add("Wert darf nicht leer sein");
            return result;
        }

        for (Function<String, String> rule : rules) {
            String validated = rule.apply(value);
            if (validated != null)
                result.add(validated);
        }
        return result;
    }
}
