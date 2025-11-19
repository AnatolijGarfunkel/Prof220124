package lesson_12_functional_interfaces.first_task;

import java.util.Optional;

@FunctionalInterface
public interface StringValidator {

    Optional<String> validate(String text);
}
