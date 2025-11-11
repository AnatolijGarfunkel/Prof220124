package lesson_12_functional_interfaces;

@FunctionalInterface
public interface StringPredicator {

    boolean test(String text);

    default StringPredicator and(StringPredicator other) {
        return text -> StringPredicator.this.test(text) && other.test(text);
    }
}
