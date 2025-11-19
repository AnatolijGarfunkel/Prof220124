package lesson_12_functional_interfaces.rule_set_builder;

import lesson_12_functional_interfaces.person_validator.Person;

import java.util.List;

public class Demo {

    public static void main(String[] args) {

        RuleSet<Person> ruleSet = RuleSetBuilder.<Person>create()
                .addRule(PersonRules.nameNotEmpty())
                .addRule(PersonRules.nameMinLength(2))
                .addRule(PersonRules.ageOnlyDigits())
                .addRule(PersonRules.ageMax(130))
                .build();

        List<Person> persons = List.of(
                new Person("A", "20"),       // Name zu kurz
                new Person("Bob", "abc"),    // Alter nicht numerisch
                new Person("Clara", "200"),  // Alter zu groß
                new Person("Dana", "25")     // sollte gültig sein
        );

        for (Person p : persons) {
            System.out.println("Prüfe: " + p);
            List<String> errors = ruleSet.validate(p);
            if (errors.isEmpty()) {
                System.out.println("  OK");
            } else {
                errors.forEach(err -> System.out.println("  Fehler: " + err));
            }
            System.out.println();
        }
    }
}

