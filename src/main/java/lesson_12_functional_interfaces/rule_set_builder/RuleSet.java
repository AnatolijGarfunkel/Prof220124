package lesson_12_functional_interfaces.rule_set_builder;

import java.util.ArrayList;
import java.util.List;

public class RuleSet<T> {

    private final List<Rule<T>> rules = new ArrayList<>();

    public void addRule(Rule<T> rule) {
        rules.add(rule);
    }

    public List<String> validate(T value) {
        List<String> errors = new ArrayList<>();

        for (Rule<T> rule : rules) {
            String error = rule.validate(value);
            if (error != null)
                errors.add(error);
        }
        return errors;
    }
}
