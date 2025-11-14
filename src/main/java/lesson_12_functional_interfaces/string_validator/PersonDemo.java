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
            List<String> errors = validator.validate(person);
            if (errors.isEmpty())
                System.out.println(" OK");
            else
                errors.forEach(System.out::println);
            System.out.println();
        }
    }
}
