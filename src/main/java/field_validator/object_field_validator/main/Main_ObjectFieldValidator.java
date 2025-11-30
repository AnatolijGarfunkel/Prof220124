package field_validator.object_field_validator.main;

import field_validator.object_field_validator.ObjectFieldValidator;
import field_validator.records.FieldErrors;
import field_validator.records.Person;
import field_validator.records.Person_Errors;
import field_validator.string_validator_function.StringValidatorBuilder;

import java.util.ArrayList;
import java.util.List;

public class Main_ObjectFieldValidator {

    public static void main(String[] args) {

        ObjectFieldValidator<Person> nameValidator = new ObjectFieldValidator<>("name", Person::name, StringValidatorBuilder.create()
                .required()
                .beginsWithUp()
                .endsWithLow()
                .minLength(2)
                .build());

        ObjectFieldValidator<Person> ageValidator = new ObjectFieldValidator<>("age", Person::age, StringValidatorBuilder.create()
                .optional()
                .configure(value -> !value.chars().allMatch(Character::isDigit) ? "Wert darf nur Ziffern enthalten." : null)
                .configure(value -> value.length() > 3 ? "Wert darf höchstens " + 3 + " Zeichen lang sein." : null)
                .maxAge(130)
                .build());

        List<ObjectFieldValidator<Person>> validators = new ArrayList<>();
        validators.add(nameValidator);
        validators.add(ageValidator);

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Clara", "200"));
        persons.add(new Person("marcus", null));
        persons.add(new Person("DaNa", "25"));
        persons.add(new Person(null, ""));
        persons.add(new Person("a", "2020"));
        persons.add(new Person("Martin", "37"));
        persons.add(new Person("BOb", "abc"));

        List<Person_Errors> personsErrors = validatePersons(persons, validators);

        for (Person_Errors personErrors : personsErrors) {
            personErrors.print();
        }
    }

    public static List<Person_Errors> validatePersons(List<Person> persons, List<ObjectFieldValidator<Person>> validators) {
        List<Person_Errors> personsErrors = new ArrayList<>();
        for (Person person : persons) {
            List<FieldErrors> fieldErrorsList = new ArrayList<>();
            for (ObjectFieldValidator<Person> validator : validators) {
                FieldErrors fieldErrors = validator.validateObject(person);
                fieldErrorsList.add(fieldErrors);
            }
            personsErrors.add(new Person_Errors(person, fieldErrorsList));
        }
        return personsErrors;
    }
}















































