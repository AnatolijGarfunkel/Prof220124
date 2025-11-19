package lesson_12_functional_interfaces.field_dsl;

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

    public List<FieldValidatorError> validateObject(T object) {
        List<FieldValidatorError> result = new ArrayList<>();
        String fieldValue = extractor.apply(object);
        List<String> errors = stringValidator.validate(fieldValue);

        for (String error : errors)
            result.add(new FieldValidatorError(fieldValue, error));

        return result;
    }
}
