package field_validator.string_validator;

@FunctionalInterface
public interface StringRule {

    String validateString(String value);
}
