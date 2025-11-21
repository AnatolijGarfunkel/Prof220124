package field_validator.object_field_validator;

import field_validator.records.FieldErrors;
import field_validator.records.Person;
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

        List<Person> persons = List.of(
                new Person("Clara", "200"),
                new Person("marcus", null),
                new Person("DaNa", "25"),
                new Person(null, ""),
                new Person("a", "2020"),
                new Person("Martin", "37"),
                new Person("BOb", "abc")
        );

        List<FieldErrors> fieldErrorsList = validatePersons(persons, validator);
        for (FieldErrors fieldErrors : fieldErrorsList) {
            System.out.println();
            if (fieldErrors.messages().isEmpty())
                System.out.println(fieldErrors.field() + ": " + fieldErrors.value() + ": OK");
            else {
                List<String> messages = fieldErrors.messages();
                for (String message : messages)
                    System.out.println(fieldErrors.field() + ": " + fieldErrors.value() + ": " + message);
            }
        }

    }

    public static List<FieldErrors> validatePersons(List<Person> persons, ObjectFieldValidatorSet<Person> validator) {
        List<FieldErrors> fieldErrorsList = new ArrayList<>();
        for (Person person : persons) {
            List<FieldErrors> list = validator.validateObject(person);
            fieldErrorsList.addAll(list);
        }
        return fieldErrorsList;
    }

}















































