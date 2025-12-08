package records_validator.person_validator;

import field_validator.records.Person;

import java.util.List;

public record PersonMessages(Person person, List<String> messages) {

    void print() {
        System.out.println("\nName: " + person.name() + " age: " + person.age());
        if (messages().isEmpty())
            System.out.println("OK.");
        else
            for (String message : messages())
                System.out.println(message);
    }
}
