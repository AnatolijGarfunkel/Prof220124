package records_validator.object_rules;

import java.util.ArrayList;
import java.util.List;

public class ObjectValidator<T> {

    private final List<ObjectRule<T>> rules = new ArrayList<>();

    public void addRule(ObjectRule<T> rule) {
        rules.add(rule);
    }

    public List<String> validateObject(T object) {
        List<String> errors = new ArrayList<>();

        for (ObjectRule<T> rule : rules) {
            boolean ok = rule.condition().test(object);
            if (!ok)
                errors.add(rule.message());
        }

        return errors;
    }
}
