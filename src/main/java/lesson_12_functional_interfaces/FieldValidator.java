package lesson_12_functional_interfaces;

import java.util.Optional;

@FunctionalInterface
public interface FieldValidator {

    Optional<String> validate(String value);

    default FieldValidator and(FieldValidator other) {
        return value -> {
            Optional<String> thisOptional = this.validate(value);
            if (thisOptional.isPresent())
                return thisOptional;
            return other.validate(value);
        };
    }

    default FieldValidator or(FieldValidator other) {
        return value -> {
            if (FieldValidator.this.validate(value).isEmpty() || other.validate(value).isEmpty())
                return Optional.empty();
            return Optional.of("Fehler");
        };
    }
}
