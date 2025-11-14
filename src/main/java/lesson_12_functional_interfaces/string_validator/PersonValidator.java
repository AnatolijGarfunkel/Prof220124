package lesson_12_functional_interfaces.string_validator;

import java.util.ArrayList;
import java.util.List;

public class PersonValidator {

    public List<ValidationError> validate(Person person) {
        List<ValidationError> result = new ArrayList<>();

        StringValidator nameValidator = new StringValidator();
        nameValidator.addRule(StringRules.notEmpty());
        nameValidator.addRule(StringRules.minLength(2));

        List<String> nameErrors = nameValidator.validate(person.name());
        for (String data : nameErrors)
            result.add(new ValidationError(person.name(), data));

        StringValidator ageValidator = new StringValidator();
        ageValidator.addRule(StringRules.notEmpty());
        ageValidator.addRule(StringRules.onlyDigits());

        List<String> ageErrors = ageValidator.validate(person.age());
        for (String data : ageErrors)
            result.add(new ValidationError(person.age(), data));

        if (ageErrors.isEmpty()) {
            int age = Integer.parseInt(person.age());
            if (age < 0 || age > 130)
                result.add(new ValidationError(person.age(), "Alter muss zwischen 0 ung 130 liegen."));
        }

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















































