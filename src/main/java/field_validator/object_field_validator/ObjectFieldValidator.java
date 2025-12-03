package field_validator.object_field_validator;

import field_validator.records.FieldErrors;
import field_validator.string_validator_predicate.PredicateStringValidator;
//import field_validator.string_validator_function.StringValidator;

import java.util.List;
import java.util.function.Function;

public class ObjectFieldValidator<T> {

    private final String field;

    private final Function<T, String> extractor;

    private final PredicateStringValidator validator;

    public ObjectFieldValidator(String field, Function<T, String> extractor, PredicateStringValidator validator) {
        this.field = field;
        this.extractor = extractor;
        this.validator = validator;
    }

    public FieldErrors validateObject(T object) {
        if (object == null)
            return new FieldErrors(field, null, List.of("Object ist null."));
        String value = extractor.apply(object);
        List<String> errors = validator.validate(value);
        FieldErrors fieldErrors = new FieldErrors(field, value, errors);
        return fieldErrors;
    }
}
