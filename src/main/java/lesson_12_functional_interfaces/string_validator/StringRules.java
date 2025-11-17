package lesson_12_functional_interfaces.string_validator;

public class StringRules {

    public static StringRule minLength(int length) {
        return value -> {
            if (value.length() < length)
                return "Wert muss mindestens " + length + " Zeichen lang sein";
            return null;
        };
    }

    public static StringRule onlyDigits() {
        return value -> {
            if (!value.chars().allMatch(Character::isDigit)) {
                return "Wert darf nur Ziffern enthalten.";
            }
            return null;
        };
    }

    public static StringRule maxLength(int max) {
        return value -> {
            if (value.length() > max)
                return "Wert darf höchstens " + max + " Zeichen lang sein.";
            return null;
        };
    }

    public static StringRule maxAge(int age) {
        return value -> {
            if (onlyDigits().validate(value) == null) {
                return Integer.parseInt(value) < 0 || Integer.parseInt(value) > age ? "Wert liegt nicht im Bereich zw. 0 und " + age : null;
            }
            return "Wert lässt sich nicht in ein Integer umwandeln";
        };
    }

    public static StringRule beginsWithUp() {
        return value -> !Character.isUpperCase(value.charAt(0)) ? "Wer beginnt nicht mit einem Großbuchstaben" : null;
    }
}















































