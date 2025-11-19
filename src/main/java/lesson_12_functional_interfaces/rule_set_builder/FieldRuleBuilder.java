package lesson_12_functional_interfaces.rule_set_builder;

import lesson_12_functional_interfaces.string_validator.StringValidator;
import lesson_12_functional_interfaces.string_validator.StringValidatorBuilder;

import java.util.function.Function;

public class FieldRuleBuilder<T> {

    private final String fieldName;

    private final Function<T, String> extractor;

    private final StringValidatorBuilder stringValidatorBuilder = StringValidatorBuilder.create();

    public FieldRuleBuilder(String fieldName, Function<T, String> extractor) {
        this.fieldName = fieldName;
        this.extractor = extractor;
    }

    public static <T> FieldRuleBuilder<T> forField(String fieldName, Function<T, String> extractor) {
        return new FieldRuleBuilder<>(fieldName, extractor);
    }

    public FieldRuleBuilder<T> minLength(int min) {
        stringValidatorBuilder.minLength(min);
        return this;
    }

    public FieldRuleBuilder<T> onlyDigits() {
        stringValidatorBuilder.onlyDigits();
        return this;
    }

    public FieldRuleBuilder<T> maxAge(int max) {
        stringValidatorBuilder.maxAge(max);
        return this;
    }

    public FieldRule<T> build() {
        StringValidator validator = stringValidatorBuilder.build();
        return new FieldRule<>(fieldName, extractor, validator);
    }
}
