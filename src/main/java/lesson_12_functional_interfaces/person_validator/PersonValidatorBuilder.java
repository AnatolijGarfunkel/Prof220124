package lesson_12_functional_interfaces.person_validator;

import lesson_12_functional_interfaces.string_validator.StringValidator;
import lesson_12_functional_interfaces.string_validator.StringValidatorBuilder;

public class PersonValidatorBuilder {

    private final StringValidatorBuilder nameBuilder = StringValidatorBuilder.create();
    private final StringValidatorBuilder ageBuilder = StringValidatorBuilder.create();

    private PersonValidatorBuilder() {
        //
    }

    public static PersonValidatorBuilder create() {
        return new PersonValidatorBuilder();
    }

    @FunctionalInterface
    public interface StringValidatorConfigurator {
        void configure(StringValidatorBuilder builder);
    }

    public PersonValidatorBuilder withDefaultNameRules() {
        nameBuilder
                .minLength(2);
        return this;
    }

    public PersonValidatorBuilder withDefaultAgeRules() {
        ageBuilder
                .onlyDigits()
                .maxLength(3)
                .maxAge(130);
        return this;
    }

    public PersonValidatorBuilder configureName(StringValidatorConfigurator config) {
        config.configure(nameBuilder);
        return this;
    }

    public PersonValidatorBuilder configureAge(StringValidatorConfigurator config) {
        config.configure(ageBuilder);
        return this;
    }

    public PersonValidator build() {
        StringValidator nameValidator = nameBuilder.build();
        StringValidator ageValidator = ageBuilder.build();
        return new PersonValidator(nameValidator, ageValidator);
    }
}
