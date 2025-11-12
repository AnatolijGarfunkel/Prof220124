package lesson_12_functional_interfaces;

import java.util.Optional;

@FunctionalInterface
public interface StringValidator {

    Optional<String> validate(String text);
}
