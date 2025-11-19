package lesson_12_functional_interfaces.first_task;

import java.util.Optional;

@FunctionalInterface
public interface FT_StringValidator {

    Optional<String> validate(String text);
}
