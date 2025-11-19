package lesson_12_functional_interfaces.main;

import lesson_12_functional_interfaces.field_dsl.FieldRule;
import lesson_12_functional_interfaces.field_dsl.FieldValidatorError;
import lesson_12_functional_interfaces.person_validator.Person;
import lesson_12_functional_interfaces.string_validator.StringRules;
import lesson_12_functional_interfaces.string_validator.StringValidator;

import java.util.ArrayList;
import java.util.List;

public class FieldRuleDemo {

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
            StringValidator nameValidator = new StringValidator();
            nameValidator.addRule(StringRules.beginsWithUp());
            nameValidator.addRule(StringRules.minLength(2));
            FieldRule<Person> nameFieldRule = new FieldRule<>(name, Person::name, nameValidator);
            List<FieldValidatorError> nameErrors = nameFieldRule.validateObject(person);
            List<FieldValidatorError> errors = new ArrayList<>(nameErrors);

            StringValidator ageValidator = new StringValidator();
            ageValidator.addRule(StringRules.onlyDigits());
            ageValidator.addRule(StringRules.maxLength(3));
            ageValidator.addRule(StringRules.maxAge(130));
            FieldRule<Person> ageFieldRule = new FieldRule<>(age, Person::age, ageValidator);
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
