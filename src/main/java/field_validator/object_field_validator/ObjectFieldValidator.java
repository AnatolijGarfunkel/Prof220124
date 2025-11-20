package field_validator.object_field_validator;

import field_validator.records.FieldErrors;
import field_validator.string_validator_function.StringValidator;

import java.util.List;

public class ObjectFieldValidator<T> {

    private final String field;

    private final String value;

    private final StringValidator validator;

    public ObjectFieldValidator(String field, String value, StringValidator validator) {
        this.field = field;
        this.value = value;
        this.validator = validator;
    }

    public FieldErrors validate(String value) {
        List<String> errors = validator.validate(value);
        FieldErrors fieldErrors = new FieldErrors(field, value, errors);
        return fieldErrors;
    }
}
