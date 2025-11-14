package lesson_12_functional_interfaces.string_validator;

@FunctionalInterface
public interface StringRule {

    String validate(String value);
}
