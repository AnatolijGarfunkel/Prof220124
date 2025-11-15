package lesson_12_functional_interfaces.string_validator;

public class StringValidatorBuilder {

    private final StringValidator validator = new StringValidator();

    private StringValidatorBuilder() {

    }

    public static StringValidatorBuilder create() {

        return new StringValidatorBuilder();
    }

    public StringValidatorBuilder noEmpty() {
        validator.addRule(StringRules.notEmpty());
        return this;
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

    public StringValidator build() {
        return validator;
    }

}
