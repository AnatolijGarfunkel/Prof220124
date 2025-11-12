package lesson_12_functional_interfaces;

@FunctionalInterface
public interface StringPredicator {

    boolean test(String text);

    default StringPredicator and(StringPredicator other) {
        return text -> StringPredicator.this.test(text) && other.test(text);
    }

    default StringPredicator or(StringPredicator other) {
        return text -> this.test(text) || other.test(text);
    }

    default StringPredicator negate() {
        return text -> !this.test(text);
    }


}
