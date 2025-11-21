package field_validator.object_field_validator;

import field_validator.records.FieldErrors;

import java.util.ArrayList;
import java.util.List;

public class ObjectFieldValidatorSet<T> {

    private final List<ObjectFieldValidator<T>> objectFieldValidators = new ArrayList<>();

    public void addObjectFieldValidator(ObjectFieldValidator<T> objectFieldValidator) {
        objectFieldValidators.add(objectFieldValidator);
    }

    public List<FieldErrors> validateObject(T object) {
        List<FieldErrors> fieldErrorsList = new ArrayList<>();

        for (ObjectFieldValidator<T> validator : objectFieldValidators) {
            FieldErrors fieldErrors = validator.validateObject(object);
            fieldErrorsList.add(fieldErrors);
        }

        return fieldErrorsList;
    }
}
