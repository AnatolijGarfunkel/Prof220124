package records_validator.object_rules;

import java.util.function.Predicate;

public record ObjectRule<T>(Predicate<T> condition, String message) {
}
