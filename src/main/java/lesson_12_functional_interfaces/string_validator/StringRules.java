package lesson_12_functional_interfaces.string_validator;

public class StringRules {

    public static StringRule notEmpty() {
        return value -> {
            if (value.isEmpty())
                return "Wert darf nicht leer sein";
            return null;
        };
    }

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
}
