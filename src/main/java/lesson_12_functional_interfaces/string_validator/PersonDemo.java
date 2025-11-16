package lesson_12_functional_interfaces.string_validator;

import java.util.List;

public class PersonDemo {

    public static void main(String[] args) {

        PersonValidator validator = PersonValidatorBuilder.create()
                .withDefaultNameRules()
                .withDefaultAgeRules()
                .build();

        List<Person> persons = List.of(
                new Person("A", "20"),
                new Person("Bob", "abc"),
                new Person("Clara", "200"),
                new Person("Dana", "25")
        );

        List<PersonalValidationResult> results = validator.validateAll(persons);

        for (PersonalValidationResult result : results) {
            System.out.println("Prüfe: " + result.person());
            if (result.isValid())
                System.out.println(" OK");
            else {
                for (ValidationError err : result.errors())
                    System.out.println("Fehler in Feld '" + err.fieldName() + "': " + err.message());
            }
        }
    }
}
