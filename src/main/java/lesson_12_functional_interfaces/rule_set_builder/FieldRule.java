package lesson_12_functional_interfaces.rule_set_builder;

import lesson_12_functional_interfaces.string_validator.StringValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FieldRule<T>{

    private final String fieldName;

    private final Function<T, String> extractor;

    private final StringValidator stringValidator;

    public FieldRule(String fieldName, Function<T, String> extractor, StringValidator stringValidator) {
        this.fieldName = fieldName;
        this.extractor = extractor;
        this.stringValidator = stringValidator;
    }

    public String getFieldName() {
        return fieldName;
    }

    public List<FieldValidatorError> validate(T value) {
        List<FieldValidatorError> result = new ArrayList<>();
        String fieldValue = extractor.apply(value);
        List<String> errors = stringValidator.validate(fieldValue);

        for (String error : errors)
            result.add(new FieldValidatorError(fieldValue, error));

        return result;
    }
}
