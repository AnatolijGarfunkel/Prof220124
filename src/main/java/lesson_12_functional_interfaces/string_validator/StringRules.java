package lesson_12_functional_interfaces.string_validator;

public class StringRules {

    public static StringRule notNull() {
        return value -> {
            if (value == null)
                return "Wert darf nicht null sein";
            return null;
        };
    }

    public static StringRule notEmpty() {
        return value -> {
            if (value != null && value.isEmpty())
                return "Wert darf nicht leer sein";
            return null;
        };
    }

    public static StringRule minLength(int length) {
        return value -> {
            if (value != null && value.length() < length)
                return "Wert muss mindestens " + length + " Zeichen lang sein";
            return null;
        };
    }
}
