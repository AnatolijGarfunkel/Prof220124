package field_validator.string_validator;

import java.util.function.Consumer;

public class StringValidatorBuilder {

    private final StringValidator validator = new StringValidator();

    private StringValidatorBuilder() {

    }

    public static StringValidatorBuilder create() {

        return new StringValidatorBuilder();
    }

    public StringValidatorBuilder minLength(int length) {
        validator.addRule(StringRules.minLength(length));
        return this;
    }

    public StringValidatorBuilder onlyDigits() {
        validator.addRule(StringRules.onlyDigits());
        return this;
    }

    public StringValidatorBuilder maxLength(int max) {
        validator.addRule(StringRules.maxLength(max));
        return this;
    }

    public StringValidatorBuilder maxAge(int age) {
        validator.addRule(StringRules.maxAge(age));
        return this;
    }

    public StringValidatorBuilder beginsWithUp() {
        validator.addRule(StringRules.beginsWithUp());
        return this;
    }

    public StringValidatorBuilder configure(StringRule rule) {
        validator.addRule(rule);
        return this;
    }

    public StringValidator build() {
        return validator;
    }

}















































