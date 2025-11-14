package lesson_12_functional_interfaces.string_validator;

import java.util.ArrayList;
import java.util.List;

public class StringValidator {

    private final List<StringRule> rules = new ArrayList<>();

    public void addRule(StringRule rule) {
        rules.add(rule);
    }

    public List<String> validate(String value) {
        List<String> result = new ArrayList<>();
        for (StringRule rule : rules) {
            String validated = rule.validate(value);
            if (validated != null)
                result.add(validated);
        }
        return result;
    }
}
