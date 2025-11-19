package lesson_12_functional_interfaces.person_validator;

import lesson_12_functional_interfaces.string_validator.ValidationError;

import java.util.List;

public record PersonalValidationResult(
        Person person,
        List<ValidationError> errors
) {
    public boolean isValid() {
        return errors == null || errors.isEmpty();
    }
}
