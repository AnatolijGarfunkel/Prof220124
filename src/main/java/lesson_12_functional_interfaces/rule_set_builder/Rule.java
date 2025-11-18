package lesson_12_functional_interfaces.rule_set_builder;

@FunctionalInterface
public interface Rule<T> {

    String validate(T value);
}
