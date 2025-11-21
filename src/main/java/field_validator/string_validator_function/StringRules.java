package field_validator.string_validator_function;

import java.util.function.Function;

public class StringRules {

    public static Function<String, String> minLength(int length) {
        return value -> value.length() < length ? "Wert muss mindestens " + length + " Zeichen lang sein." : null;
    }

    public static Function<String, String> onlyDigits() {
        return value -> !value.chars().allMatch(Character::isDigit) ? "Wert darf nur Ziffern enthalten." : null;
    }

    public static Function<String, String> maxLength(int max) {
        return value -> value.length() > max ? "Wert darf höchstens " + max + " Zeichen lang sein." : null;
    }

    public static Function<String, String> maxAge(int age) {
        return value -> {
            if (onlyDigits().apply(value) == null) {
                return Integer.parseInt(value) < 0 || Integer.parseInt(value) > age ? "Wert liegt nicht im Bereich zw. 0 und " + age : null;
            }
            return "Wert lässt sich nicht in ein Integer umwandeln";
        };
    }

    public static Function<String, String> beginsWithUp() {
        return value -> !Character.isUpperCase(value.charAt(0)) ? "Wert beginnt nicht mit einem Großbuchstaben" : null;
    }

    public static Function<String,String> endsWithLow() {
        return value -> {
            value = value.substring(1);
            char[] chars = value.toCharArray();
            for (char c : chars)
                if (!Character.isLowerCase(c))
                    return  "Wert endet nicht mit einem Kleinbuchstaben";
            return null;
        };
    }
}


































/*
    public static StringRule minLength(int length) {
        return value -> value.length() < length ? "Wert muss mindestens " + length + " Zeichen lang sein." : null;
    }

    public static StringRule onlyDigits() {
        return value -> !value.chars().allMatch(Character::isDigit) ? "Wert darf nur Ziffern enthalten." : null;
    }

    public static StringRule maxLength(int max) {
        return value -> value.length() > max ? "Wert darf höchstens " + max + " Zeichen lang sein." : null;
    }

    public static StringRule maxAge(int age) {
        return value -> {
            if (onlyDigits().validateString(value) == null) {
                return Integer.parseInt(value) < 0 || Integer.parseInt(value) > age ? "Wert liegt nicht im Bereich zw. 0 und " + age : null;
            }
            return "Wert lässt sich nicht in ein Integer umwandeln";
        };
    }

    public static StringRule beginsWithUp() {
        return value -> !Character.isUpperCase(value.charAt(0)) ? "Wert beginnt nicht mit einem Großbuchstaben" : null;
    }

 */













































