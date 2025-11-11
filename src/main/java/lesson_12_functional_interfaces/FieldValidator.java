package lesson_12_functional_interfaces;

import java.util.Optional;

@FunctionalInterface
public interface FieldValidator {

    Optional<String> validate(String value);
}
