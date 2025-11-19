package lesson_12_functional_interfaces.rule_set_builder;

import java.util.ArrayList;
import java.util.List;

public class FieldRuleSet<T> {

    private final List<FieldRule<T>> fieldRules = new ArrayList<>();

    public void addFieldRule(FieldRule<T> fieldRule) {
        fieldRules.add(fieldRule);
    }

    public List<FieldValidatorError> validate(T value) {
        List<FieldValidatorError> allErrors = new ArrayList<>();

        for (FieldRule<T> rule : fieldRules) {
            List<FieldValidatorError> errors = rule.validate(value);
            allErrors.addAll(errors);
        }

        return allErrors;
    }
}
