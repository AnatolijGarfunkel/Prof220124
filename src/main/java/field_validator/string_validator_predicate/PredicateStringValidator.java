package field_validator.string_validator_predicate;

import field_validator.records.StringRule;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateStringValidator {

    private boolean required = false;

    private boolean optional = false;

    private final List<StringRule> rules = new ArrayList<>();

    public void setRequired(boolean required) {
        this.required = required;
    }

    public void setOptional(boolean optional) {
        this.optional = optional;
    }

    public void addRule(Predicate<String> rule, String message) {
        rules.add(new StringRule(rule, message));
    }

    public List<String> validate(String value) {
        List<String> errors = new ArrayList<>();

        if (optional && (value == null || value.isEmpty()))
            return errors;

        if (required) {
            if (value == null) {
                errors.add("Wert darf nicht null sein.");
                return errors;
            }
            if (value.isEmpty()) {
                errors.add("Wert darf nicht leer sein");
                return errors;
            }
        }

        for (StringRule rule : rules) {
            Predicate<String> predicate = rule.rule();
            boolean test = predicate.test(value);
            if (!test) {
                String message = rule.message();
                errors.add(message);
            }

        }

        return errors;
    }
}
















































