package field_validator.string_validator_function.main;

import field_validator.records.FieldErrors;
import field_validator.records.Person;
import field_validator.records.Person_Errors;
import field_validator.string_validator_function.StringValidator;
import field_validator.string_validator_function.StringValidatorBuilder;

import java.util.ArrayList;
import java.util.List;

public class Main_FieldErrors {

    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Clara", "200"));
        persons.add(new Person("marcus", null));
        persons.add(new Person("DaNa", "25"));
        persons.add(new Person(null, ""));
        persons.add(new Person("a", "2020"));
        persons.add(new Person("Martin", "37"));
        persons.add(new Person("BOb", "abc"));

        StringValidator nameValidator = StringValidatorBuilder.create()
                .configure(value -> value.length() < 2 ? "Wert muss mindestens " + 2 + " Zeichen lang sein." : null)
                .beginsWithUp()
                .endsWithLow()
                .build();

        StringValidator ageValidator = StringValidatorBuilder.create()
                .configure(value -> !value.chars().allMatch(Character::isDigit) ? "Wert darf nur Ziffern enthalten." : null)
                .configure(value -> value.length() > 3 ? "Wert darf höchstens " + 3 + " Zeichen lang sein." : null)
                .maxAge(130)
                .build();

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














































