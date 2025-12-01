package field_validator.string_validator_predicate;

import java.util.function.Predicate;

public class PredicateStringValidatorBuilder {

    private final PredicateStringValidator validator = new PredicateStringValidator();

    private PredicateStringValidatorBuilder() {
        //
    }

    public static PredicateStringValidatorBuilder create() {

        return new PredicateStringValidatorBuilder();
    }

    public PredicateStringValidatorBuilder required() {
        validator.setRequired(true);
        validator.setOptional(false);
        return this;
    }

    public PredicateStringValidatorBuilder optional() {
        validator.setOptional(true);
        validator.setRequired(false);
        return this;
    }

    public PredicateStringValidatorBuilder minLength(int length) {
        validator.addRule(PredicateStringRules.minLength(length), "Wert muss mindestens " + length + " Zeichen lang sein.");
        return this;
    }

    public PredicateStringValidatorBuilder minLength(int length, String message) {
        validator.addRule(PredicateStringRules.minLength(length), message);
        return this;
    }

    public PredicateStringValidatorBuilder onlyDigits() {
        validator.addRule(PredicateStringRules.onlyDigits(), "Wert darf nur Ziffern enthalten.");
        return this;
    }

    public PredicateStringValidatorBuilder onlyDigits(String message) {
        validator.addRule(PredicateStringRules.onlyDigits(), message);
        return this;
    }

    public PredicateStringValidatorBuilder maxLength(int max) {
        validator.addRule(PredicateStringRules.maxLength(max), "Wert darf höchstens " + max + " Zeichen lang sein.");
        return this;
    }

    public PredicateStringValidatorBuilder maxLength(int max, String message) {
        validator.addRule(PredicateStringRules.maxLength(max), message);
        return this;
    }

    public PredicateStringValidatorBuilder maxAge(int age) {
        validator.addRule(PredicateStringRules.maxAge(age), "Wert liegt nicht im Bereich zw. 0 und " + age);
        return this;
    }

    public PredicateStringValidatorBuilder maxAge(int age, String message) {
        validator.addRule(PredicateStringRules.maxAge(age), message);
        return this;
    }

    public PredicateStringValidatorBuilder beginsWithUp() {
        validator.addRule(PredicateStringRules.beginsWithUp(), "Wert beginnt nicht mit einem Großbuchstaben");
        return this;
    }

    public PredicateStringValidatorBuilder beginsWithUp(String message) {
        validator.addRule(PredicateStringRules.beginsWithUp(), message);
        return this;
    }

    public PredicateStringValidatorBuilder endsWithLow() {
        validator.addRule(PredicateStringRules.endsWithLow(), "Wert endet nicht mit einem Kleinbuchstaben");
        return this;
    }

    public PredicateStringValidatorBuilder endsWithLow(String message) {
        validator.addRule(PredicateStringRules.endsWithLow(), message);
        return this;
    }

    public PredicateStringValidatorBuilder configure(Predicate<String> rule, String message) {
        validator.addRule(rule, message);
        return this;
    }

    public PredicateStringValidator build() {
        return validator;
    }

}















































