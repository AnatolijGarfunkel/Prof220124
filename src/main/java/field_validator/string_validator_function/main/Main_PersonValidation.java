package field_validator.string_validator_function.main;

import field_validator.records.FieldErrors;
import field_validator.records.Person;
import field_validator.records.Person_Errors;
import field_validator.string_validator_function.StringRules;
import field_validator.string_validator_function.StringValidator;

import java.util.ArrayList;
import java.util.List;

public class Main_PersonValidation {

    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Clara", "200"));
        persons.add(new Person("marcus", null));
        persons.add(new Person("DaNa", "25"));
        persons.add(new Person(null, ""));
        persons.add(new Person("a", "2020"));
        persons.add(new Person("Martin", "37"));
        persons.add(new Person("BOb", "abc"));

        StringValidator nameValidator = new StringValidator();
        nameValidator.setRequired(true);
        nameValidator.addRule(StringRules.beginsWithUp());
        nameValidator.addRule(StringRules.endsWithLow());
        nameValidator.addRule(StringRules.minLength(2));

        StringValidator ageValidator = new StringValidator();
        ageValidator.setOptional(true);
        ageValidator.addRule(StringRules.maxLength(3));
        ageValidator.addRule(StringRules.onlyDigits());
        ageValidator.addRule(StringRules.maxAge(130));

        List<Person_Errors> personsErrors = new ArrayList<>();

        for (Person person : persons) {

            String field;
            String value;

            field = "name";
            value = person.name();
            List<String> nameErrors = nameValidator.validate(value);
            FieldErrors nameFieldErrors = new FieldErrors(field, value, nameErrors);

            field = "age";
            value = person.age();
            List<String> ageErrors = ageValidator.validate(value);
            FieldErrors ageFieldErrors = new FieldErrors(field, value, ageErrors);

            List<FieldErrors> fieldErrors = List.of(nameFieldErrors, ageFieldErrors);
            personsErrors.add(new Person_Errors(person, fieldErrors));
        }

        for (Person_Errors personErrors : personsErrors) {
            personErrors.print();
        }
    }
}
















































