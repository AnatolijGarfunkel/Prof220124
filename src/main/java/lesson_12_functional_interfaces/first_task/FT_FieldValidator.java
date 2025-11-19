package lesson_12_functional_interfaces.first_task;

import java.util.Optional;

@FunctionalInterface
public interface FT_FieldValidator {

    Optional<String> validate(String value);

    default FT_FieldValidator and(FT_FieldValidator other) {
        return value -> {
            Optional<String> thisOptional = this.validate(value);
            if (thisOptional.isPresent())
                return thisOptional;
            return other.validate(value);
        };
    }

    default FT_FieldValidator or(FT_FieldValidator other) {
        return value -> {
            if (FT_FieldValidator.this.validate(value).isEmpty() || other.validate(value).isEmpty())
                return Optional.empty();
            return Optional.of("Fehler");
        };
    }
}
