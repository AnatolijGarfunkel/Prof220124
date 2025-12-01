package field_validator.string_validator_predicate;

import java.util.function.Predicate;

public class PredicateStringRules {

    public static Predicate<String> minLength(int min) {
        return value -> value.length() >= min;
    }

    public static Predicate<String>  maxLength(int max) {
        return value -> value.length() <= max;
    }

    public static Predicate<String>  onlyDigits() {
        return value -> value.chars().allMatch(Character::isDigit);
    }

    public static Predicate<String>  maxAge(int age) {
        return value -> {
            if (onlyDigits().test(value)) {
                return Integer.parseInt(value) > 0 && Integer.parseInt(value) < age;
            }
            return false;
        };
    }

    public static Predicate<String>  beginsWithUp() {
        return value -> Character.isUpperCase(value.charAt(0));
    }

    public static Predicate<String>  endsWithLow() {
        return value -> {
            value = value.substring(1);
            char[] chars = value.toCharArray();
            for (char c : chars)
                if (!Character.isLowerCase(c))
                    return false;
            return true;
        };
    }
}
