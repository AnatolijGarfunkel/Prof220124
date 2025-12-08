package records_validator.person_validator;

import field_validator.records.Person;
import field_validator.string_validator_predicate.PredicateStringRules;

import java.util.function.Predicate;

public class PersonFieldRules {

    public static Predicate<Person> beginsWithUp() {
        return person -> {
            if (isNull(person.name()))
                return false;
           return Character.isUpperCase(person.name().charAt(0));
        };
    }

    public static Predicate<Person> endsWithLow() {
        return person -> {
            if (isNull(person.name()))
                return false;
            String name = person.name();
            name = name.substring(1);
            char[] chars = name.toCharArray();
            for (char c : chars)
                if (!Character.isLowerCase(c))
                    return false;
            return true;
        };
    }

    public static Predicate<Person> minAge(int age) {
        return person -> {
            if (isNull(person.age()))
                return false;
            Predicate<String> predicate = PredicateStringRules.onlyDigits();
            if (!predicate.test(person.age()))
                return false;
            return Integer.parseInt(person.age()) >= age;
        };
    }

    public static Predicate<Person> maxAge(int age) {
        return person -> {
            if (isNull(person.age()))
                return false;
            Predicate<String> predicate = PredicateStringRules.onlyDigits();
            if (!predicate.test(person.age()))
                return false;
            return Integer.parseInt(person.age()) <= age;
        };
    }

    private static boolean isNull(String value) {
        return value == null || value.isEmpty();
    }
}
