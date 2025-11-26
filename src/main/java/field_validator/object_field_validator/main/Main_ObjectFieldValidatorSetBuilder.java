package field_validator.object_field_validator.main;

import field_validator.object_field_validator.ObjectFieldValidatorSet;
import field_validator.object_field_validator.ObjectFieldValidatorSetBuilder;
import field_validator.records.FieldErrors;
import field_validator.records.Person;
import field_validator.records.Person_Errors;
import field_validator.string_validator_function.StringValidatorBuilder;

import java.util.ArrayList;
import java.util.List;

public class Main_ObjectFieldValidatorSetBuilder {

    public static void main(String[] args) {

        ObjectFieldValidatorSet<Person> validator = ObjectFieldValidatorSetBuilder.<Person>create()
                .field("name", Person::name, StringValidatorBuilder.create()
                        .beginsWithUp()
                        .endsWithLow()
                        .minLength(2)
                        .build())
                .field("age", Person::age, StringValidatorBuilder.create()
                        .onlyDigits()
                        .maxAge(130)
                        .maxLength(3)
                        .build())
                .build();

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Clara", "200"));
        persons.add(new Person("marcus", null));
        persons.add(new Person("DaNa", "25"));
        persons.add(new Person(null, ""));
        persons.add(new Person("a", "2020"));
        persons.add(new Person("Martin", "37"));
        persons.add(new Person("BOb", "abc"));

        List<Person_Errors> personsErrors = validatePersons(persons, validator);

        for (Person_Errors personErrors : personsErrors) {
            personErrors.print();
        }
    }

    public static List<Person_Errors> validatePersons(List<Person> persons, ObjectFieldValidatorSet<Person> validator) {
        List<Person_Errors> personsErrors = new ArrayList<>();
        for (Person person : persons) {
            List<FieldErrors> fieldErrors = validator.validateObject(person);
            personsErrors.add(new Person_Errors(person, fieldErrors));
        }
        return personsErrors;
    }
}















































