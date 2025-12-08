package records_validator.object_rules;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        ObjectRule<Person> nameNotEmpty = new ObjectRule<>(
                person -> person.name() != null && !person.name().isBlank(),
                "Name darf nicht leer sein."
        );

        ObjectRule<Person> minorNeedsParentConsent = new ObjectRule<>(
                person -> person.age() >= 18 || person.parentConsent(),
                "Minderjährige brauchen eine elterliche Zustimmung."
        );

        ObjectValidator<Person> validator = new ObjectValidator<>();

        validator.addRule(nameNotEmpty);
        validator.addRule(minorNeedsParentConsent);

        Person person = new Person(null, 15, false);

        List<String> errors = validator.validateObject(person);

        if (errors.isEmpty())
            System.out.println("Person ist gültig.");
        else {
            System.out.println("Fehler bei Person:");
            for (String error : errors)
                System.out.println(" - " + error);
        }
    }
}
