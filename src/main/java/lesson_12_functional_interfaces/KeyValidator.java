package lesson_12_functional_interfaces;

@FunctionalInterface
public interface KeyValidator {

    boolean validate(String key);
}
