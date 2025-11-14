package lesson_12_functional_interfaces.string_validator;

import java.util.ArrayList;
import java.util.List;

public class StringValidator {

    private List<StringRule> rules = new ArrayList();

    public void addRule(StringRule rule) {
        rules.add(rule);
    }

    public List<String> validates(String value) {
        List<String> result = new ArrayList<>();
        for (StringRule rule : rules) {
            String validated = rule.validate(value);
            if (!validated.equals("null"))
                result.add(validated);
        }
        return result;
    }
}
