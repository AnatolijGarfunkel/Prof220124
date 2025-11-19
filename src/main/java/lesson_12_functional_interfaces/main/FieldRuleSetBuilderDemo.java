package lesson_12_functional_interfaces.main;

import lesson_12_functional_interfaces.field_dsl.FieldRuleSet;
import lesson_12_functional_interfaces.field_dsl.FieldRuleSetBuilder;
import lesson_12_functional_interfaces.field_dsl.FieldValidatorError;
import lesson_12_functional_interfaces.person_validator.Person;

import java.util.List;

public class FieldRuleSetBuilderDemo {

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
            FieldRuleSet<Person> rules = FieldRuleSetBuilder.<Person>create()
                    .field(name, Person::name, builder -> builder
                            .beginWithUp()
                            .minLength(2)
                    )
                    .field(age, Person::age, builder -> builder
                            .onlyDigits()
                            .maxLength(3)
                            .maxAge(130)
                    )
                    .build();

            List<FieldValidatorError> errors = rules.validate(person);

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
