package field_validator.object_field_validator;

import field_validator.string_validator_function.StringValidator;

import java.util.function.Function;

public class ObjectFieldValidatorSetBuilder<T> {

    private final ObjectFieldValidatorSet<T> objectFieldValidatorsSet = new ObjectFieldValidatorSet<>();

    private ObjectFieldValidatorSetBuilder() {
        //
    }

    public static <T> ObjectFieldValidatorSetBuilder<T> create() {
        return new ObjectFieldValidatorSetBuilder<>();
    }

    public ObjectFieldValidatorSetBuilder<T> field(String field, Function<T, String> extractor, StringValidator validator) {
        ObjectFieldValidator<T> objectFieldValidator = new ObjectFieldValidator<>(field, extractor, validator);
        objectFieldValidatorsSet.addObjectFieldValidator(objectFieldValidator);
        return this;
    }

    public ObjectFieldValidatorSet<T> build() {
        return objectFieldValidatorsSet;
    }
}
