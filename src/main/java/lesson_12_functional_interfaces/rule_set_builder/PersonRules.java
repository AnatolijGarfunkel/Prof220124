package lesson_12_functional_interfaces.rule_set_builder;

import lesson_12_functional_interfaces.person_validator.Person;

public class PersonRules {

    public static Rule<Person> nameNotEmpty() {
        return person -> person.name() == null || person.name().isEmpty() ? "Name darf nicht leer sein." : null;
    }

    public static Rule<Person> nameMinLength(int min) {
        return person -> person.name() != null && person.name().length() < min ? "Name muss mindestens " + min + " Zeichen lang sein." : null;
    }

    public static Rule<Person> ageOnlyDigits() {
        return person -> {
            String age = person.age();
            if (age == null || age.isEmpty()) {
                return "Alter darf nicht leer sein.";
            }
            boolean allDigits = age.chars().allMatch(Character::isDigit);
            if (!allDigits) {
                return "Alter darf nur Ziffern enthalten.";
            }
            return null;
        };
    }

    public static Rule<Person> ageMax(int max) {
        return person -> {
            String age = person.age();
            if (age == null || age.isEmpty()) {
                return "Alter darf nicht leer sein.";
            }
            if (!age.chars().allMatch(Character::isDigit)) {
                return "Alter darf nur Ziffern enthalten.";
            }
            int value = Integer.parseInt(age);
            if (value < 0 || value > max) {
                return "Alter muss zwischen 0 und " + max + " liegen.";
            }
            return null;
        };
    }
}
