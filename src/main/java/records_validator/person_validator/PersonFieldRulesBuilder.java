package records_validator.person_validator;

import field_validator.records.Person;
import field_validator.string_validator_predicate.PredicateStringRules;
import records_validator.object_rules.ObjectRule;
import records_validator.object_rules.ObjectValidator;

import java.util.function.Predicate;

public class PersonFieldRulesBuilder {

    private final ObjectValidator<Person> validator = new ObjectValidator<>();

    private PersonFieldRulesBuilder() {
        //
    }


    public static PersonFieldRulesBuilder create() {
        return new PersonFieldRulesBuilder();
    }

    private boolean isNull(String value) {
        return value == null || value.isEmpty();
    }

    public PersonFieldRulesBuilder nameNotNull() {
        ObjectRule<Person> notNull = new ObjectRule<>(
                person -> person.name() != null,
                "Name darf nicht null sein."
        );
        ObjectRule<Person> notEmpty = new ObjectRule<>(
                person -> person.name() != null && !person.name().isEmpty(),
                "Name darf nicht leer sein.");
        validator.addRule(notNull);
        validator.addRule(notEmpty);
        return this;
    }

    public PersonFieldRulesBuilder ageNotNull() {
        ObjectRule<Person> notNull = new ObjectRule<>(
                person -> person.age() != null,
                "Age darf nicht null sein.");
        ObjectRule<Person> notEmpty = new ObjectRule<>(
                person -> person.age() != null && !person.age().isEmpty(),
                "Age darf nicht leer sein.");
        validator.addRule(notNull);
        validator.addRule(notEmpty);
        return this;
    }


    public PersonFieldRulesBuilder onlyAlphabetic() {
        ObjectRule<Person> onlyAlphabetic = new ObjectRule<>(
                person -> {
                    if (isNull(person.name()))
                        return false;
                    Predicate<String> stringPredicate = PredicateStringRules.onlyAlphabetic();
                    return stringPredicate.test(person.name());
                },
                "Name darf nur Buchstaben enthalten."
        );
        validator.addRule(onlyAlphabetic);
        return this;
    }

    public PersonFieldRulesBuilder onlyAlphabetic(String message) {
        ObjectRule<Person> onlyAlphabetic = new ObjectRule<>(
                person -> {
                    if (isNull(person.name()))
                        return false;
                    Predicate<String> stringPredicate = PredicateStringRules.onlyAlphabetic();
                    return stringPredicate.test(person.name());
                },
                message
        );
        validator.addRule(onlyAlphabetic);
        return this;
    }

    public PersonFieldRulesBuilder beginsWithUp() {
        ObjectRule<Person> beginsWithUp = new ObjectRule<>(PersonFieldRules.beginsWithUp(), "Name beginnt nicht mit einem Großbuchstaben.");
        validator.addRule(beginsWithUp);
        return this;
    }

    public PersonFieldRulesBuilder beginsWithUp(String message) {
        ObjectRule<Person> beginsWithUp = new ObjectRule<>(PersonFieldRules.beginsWithUp(), message);
        validator.addRule(beginsWithUp);
        return this;
    }

    public PersonFieldRulesBuilder endsWithLow() {
        ObjectRule<Person> endsWithLow = new ObjectRule<>(PersonFieldRules.endsWithLow(), "Name endet nicht mit einem Kleinbuchstaben."
        );
        validator.addRule(endsWithLow);
        return this;
    }

    public PersonFieldRulesBuilder endsWithLow(String message) {
        ObjectRule<Person> endsWithLow = new ObjectRule<>(PersonFieldRules.endsWithLow(), message
        );
        validator.addRule(endsWithLow);
        return this;
    }

    public PersonFieldRulesBuilder onlyDigits() {
        ObjectRule<Person> onlyDigits = new ObjectRule<>(
                person -> {
                    if (isNull(person.age()))
                        return false;
                    Predicate<String> predicate = PredicateStringRules.onlyDigits();
                    return predicate.test(person.age());
                },
                "Age darf nur Ziffern enthalten."
        );
        validator.addRule(onlyDigits);
        return this;
    }

    public PersonFieldRulesBuilder onlyDigits(String message) {
        ObjectRule<Person> onlyDigits = new ObjectRule<>(
                person -> {
                    if (isNull(person.age()))
                        return false;
                    Predicate<String> predicate = PredicateStringRules.onlyDigits();
                    return predicate.test(person.age());
                },
                message
        );
        validator.addRule(onlyDigits);
        return this;
    }

    public PersonFieldRulesBuilder minAge(int min) {
        ObjectRule<Person> minAge = new ObjectRule<>(PersonFieldRules.minAge(min), "Age darf nicht kleiner als " + min + " sein."
        );
        validator.addRule(minAge);
        return this;
    }

    public PersonFieldRulesBuilder minAge(int min, String message) {
        ObjectRule<Person> minAge = new ObjectRule<>(PersonFieldRules.minAge(min), message
        );
        validator.addRule(minAge);
        return this;
    }

    public PersonFieldRulesBuilder maxAge(int max) {
        ObjectRule<Person> maxAge = new ObjectRule<>(PersonFieldRules.maxAge(max), "Age darf nicht größer als " + max + " sein."
        );
        validator.addRule(maxAge);
        return this;
    }

    public PersonFieldRulesBuilder maxAge(int max, String message) {
        ObjectRule<Person> maxAge = new ObjectRule<>(PersonFieldRules.maxAge(max), message
        );
        validator.addRule(maxAge);
        return this;
    }

    public PersonFieldRulesBuilder configure(Predicate<Person> predicate, String message) {
        ObjectRule<Person> personObjectRule = new ObjectRule<>(
                predicate,
                message);
        validator.addRule(personObjectRule);
        return this;
    }

    public ObjectValidator<Person> build() {
        return validator;
    }
}















































