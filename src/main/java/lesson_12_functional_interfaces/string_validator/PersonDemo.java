package lesson_12_functional_interfaces.string_validator;

import java.util.List;

public class PersonDemo {

    public static void main(String[] args) {

        PersonValidator validator = new PersonValidator();

        List<Person> persons = List.of(
                new Person("A", "20"),
                new Person("Bob", "abc"),
                new Person("Clara", "200"),
                new Person("Dana", "25")
        );

        for (Person person : persons) {
            System.out.println("Prüfe: " + person);
            PersonalValidationResult result = validator.validateResult(person);
            if (result.isValid())
                System.out.println(" OK");
            else {
                for (ValidationError err : result.errors())
                    System.out.println(" Fehler in Feld '" + err.fieldName() + "': " + err.message());
            }
        }
    }
}
