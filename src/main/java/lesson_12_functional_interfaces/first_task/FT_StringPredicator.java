package lesson_12_functional_interfaces.first_task;

@FunctionalInterface
public interface FT_StringPredicator {

    boolean test(String text);

    default FT_StringPredicator and(FT_StringPredicator other) {
        return text -> FT_StringPredicator.this.test(text) && other.test(text);
    }

    default FT_StringPredicator or(FT_StringPredicator other) {
        return text -> this.test(text) || other.test(text);
    }

    default FT_StringPredicator negate() {
        return text -> !this.test(text);
    }


}
