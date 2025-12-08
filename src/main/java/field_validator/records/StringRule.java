package field_validator.records;

import java.util.function.Predicate;

public record StringRule(Predicate<String> rule, String message) {
}
