package lesson_12_functional_interfaces.string_validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PersonValidator {

    private final StringValidator nameValidator;

    private final StringValidator ageValidator;

    public PersonValidator(StringValidator nameValidator, StringValidator ageValidator) {
        this.nameValidator = Objects.requireNonNull(nameValidator);
        this.ageValidator = Objects.requireNonNull(ageValidator);
    }

    public List<ValidationError> validate(Person person) {
        List<ValidationError> result = new ArrayList<>();

        List<String> nameErrors = nameValidator.validate(person.name());
        for (String err : nameErrors)
            result.add(new ValidationError("name: " + person.name(), err));

        List<String> ageErrors = ageValidator.validate(person.age());
        for (String data : ageErrors)
            result.add(new ValidationError("age: " + person.age(), data));

        return result;
    }

    public PersonalValidationResult validatePerson(Person person) {
        List<ValidationError> errors = validate(person);
        return new PersonalValidationResult(person, errors);
    }

    public List<PersonalValidationResult> validateAll(List<Person> persons) {
        List<PersonalValidationResult> results = new ArrayList<>();

        for (Person person : persons) {
            PersonalValidationResult result = validatePerson(person);
            results.add(result);
        }

        return results;
    }
}















































