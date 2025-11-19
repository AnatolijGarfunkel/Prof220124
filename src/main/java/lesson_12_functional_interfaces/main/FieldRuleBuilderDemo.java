package lesson_12_functional_interfaces.main;

import lesson_12_functional_interfaces.field_dsl.FieldRule;
import lesson_12_functional_interfaces.field_dsl.FieldRuleBuilder;
import lesson_12_functional_interfaces.field_dsl.FieldValidatorError;
import lesson_12_functional_interfaces.person_validator.Person;

import java.util.ArrayList;
import java.util.List;

public class FieldRuleBuilderDemo {

    public static void main(String[] args) {

        List<Person> persons = List.of(
                new Person("A", "20"),
                new Person("Bob", "abc"),
                new Person("Clara", "200"),
                new Person("marcus", ""),
                new Person("Dana", "25"),
                new Person(null, "")
        );

        for (Person person : persons) {
            String name = person.name();
            String age = person.age();
            FieldRule<Person> nameFieldRule = new FieldRuleBuilder<>(name, Person::name)
                    .beginWithUp()
                    .minLength(2)
                    .build();
            List<FieldValidatorError> nameErrors = nameFieldRule.validateObject(person);
            List<FieldValidatorError> errors = new ArrayList<>(nameErrors);

            FieldRule<Person> ageFieldRule = new FieldRuleBuilder<Person>(age, Person::age)
                    .onlyDigits()
                    .maxLength(3)
                    .maxAge(130)
                    .build();

            List<FieldValidatorError> ageErrors = ageFieldRule.validateObject(person);
            errors.addAll(ageErrors);

            System.out.println(person);
            if (errors.isEmpty()) {
                System.out.println("  OK");
            } else {
                for (FieldValidatorError error : errors) {
                    System.out.println("  Feld '" + error.fieldName() + "': " + error.message());
                }
            }
            System.out.println();
        }
    }
}
