package lesson_12_functional_interfaces.field_dsl;

import lesson_12_functional_interfaces.person_validator.Person;

import java.util.List;

public class FieldDslDemo {

    public static void main(String[] args) {

        FieldRuleSet<Person> rules = FieldRuleSetBuilder.<Person>create()
                .field("name", Person::name, b -> b
                        .minLength(2)
                        .beginWithUp()
                )
                .field("age", Person::age, b -> b
                        .onlyDigits()
                        .maxLength(3)
                        .maxAge(130)
                )
                .build();

        List<Person> persons = List.of(
                new Person("A", "20"),
                new Person("Bob", "abc"),
                new Person("Clara", "200"),
                new Person("marcus", ""),
                new Person("Dana", "25")
        );

        for (Person person : persons) {
            System.out.println("Prüfe: " + person);
            List<FieldValidatorError> errors = rules.validate(person);
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
