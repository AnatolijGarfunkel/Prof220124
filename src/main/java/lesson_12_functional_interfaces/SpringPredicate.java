package lesson_12_functional_interfaces;

@FunctionalInterface
public interface SpringPredicate {

    boolean test(String text);
}
