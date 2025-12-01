package field_validator.string_validator_predicate;

import java.util.function.Predicate;

public class StringValidatorPredicateBuilder {

    private final StringValidatorPredicate validator = new StringValidatorPredicate();

    private StringValidatorPredicateBuilder() {
        //
    }

    public static StringValidatorPredicateBuilder create() {

        return new StringValidatorPredicateBuilder();
    }

    public StringValidatorPredicateBuilder required() {
        validator.setRequired(true);
        validator.setOptional(false);
        return this;
    }

    public StringValidatorPredicateBuilder optional() {
        validator.setOptional(true);
        validator.setRequired(false);
        return this;
    }

    public StringValidatorPredicateBuilder minLength(int length) {
        validator.addRule(StringRulesPredicate.minLength(length), "Wert muss mindestens " + length + " Zeichen lang sein.");
        return this;
    }

    public StringValidatorPredicateBuilder minLength(int length, String message) {
        validator.addRule(StringRulesPredicate.minLength(length), message);
        return this;
    }

    public StringValidatorPredicateBuilder onlyDigits() {
        validator.addRule(StringRulesPredicate.onlyDigits(), "Wert darf nur Ziffern enthalten.");
        return this;
    }

    public StringValidatorPredicateBuilder onlyDigits(String message) {
        validator.addRule(StringRulesPredicate.onlyDigits(), message);
        return this;
    }

    public StringValidatorPredicateBuilder maxLength(int max) {
        validator.addRule(StringRulesPredicate.maxLength(max), "Wert darf höchstens " + max + " Zeichen lang sein.");
        return this;
    }

    public StringValidatorPredicateBuilder maxLength(int max, String message) {
        validator.addRule(StringRulesPredicate.maxLength(max), message);
        return this;
    }

    public StringValidatorPredicateBuilder maxAge(int age) {
        validator.addRule(StringRulesPredicate.maxAge(age), "Wert liegt nicht im Bereich zw. 0 und ");
        return this;
    }

    public StringValidatorPredicateBuilder maxAge(int age, String message) {
        validator.addRule(StringRulesPredicate.maxAge(age), message);
        return this;
    }

    public StringValidatorPredicateBuilder beginsWithUp() {
        validator.addRule(StringRulesPredicate.beginsWithUp(), "Wert beginnt nicht mit einem Großbuchstaben");
        return this;
    }

    public StringValidatorPredicateBuilder beginsWithUp(String message) {
        validator.addRule(StringRulesPredicate.beginsWithUp(), message);
        return this;
    }

    public StringValidatorPredicateBuilder endsWithLow() {
        validator.addRule(StringRulesPredicate.endsWithLow(), "Wert endet nicht mit einem Kleinbuchstaben");
        return this;
    }

    public StringValidatorPredicateBuilder endsWithLow(String message) {
        validator.addRule(StringRulesPredicate.endsWithLow(), message);
        return this;
    }

    public StringValidatorPredicateBuilder configure(Predicate<String> rule, String message) {
        validator.addRule(rule, message);
        return this;
    }

    public StringValidatorPredicate build() {
        return validator;
    }

}















































