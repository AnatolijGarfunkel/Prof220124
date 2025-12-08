package records_validator.person_validator;

import field_validator.records.Person;
import records_validator.object_rules.ObjectValidator;

import java.util.ArrayList;
import java.util.List;

public class Main_PersonFieldRules {

    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Clara", "200"));
        persons.add(new Person("marcus", null));
        persons.add(new Person("DaNa", "25"));
        persons.add(new Person(null, ""));
        persons.add(new Person("a", "20205"));
        persons.add(new Person("Martin", "37"));
        persons.add(new Person("BOb", "abc"));


        ObjectValidator<Person> validator = PersonFieldRulesBuilder.create()
                .nameNotNull()
                .ageNotNull()
                .onlyAlphabetic()
                .beginsWithUp()
                .endsWithLow()
                .onlyDigits()
                .minAge(18)
                .maxAge(130)
                .build();

        List<PersonMessages> personMessages = validatePersons(persons, validator);

        for (PersonMessages personMessage : personMessages) {
            personMessage.print();
        }
    }

    public static List<PersonMessages> validatePersons(List<Person> persons, ObjectValidator<Person> validator) {
        List<PersonMessages> messages = new ArrayList<>();
        for (Person person : persons) {
            List<String> errors = validator.validateObject(person);
            messages.add(new PersonMessages(person, errors));
        }

        return messages;
    }
}

