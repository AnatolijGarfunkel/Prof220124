package lesson_12_functional_interfaces.string_validator;

import java.util.List;

public class FirstStep {

    public static void main(String[] args) {

        StringRule notEmpty = value -> {
            if (value != null && value.isEmpty())
                return "Wert darf nicht leer sein";
            return null;
        };

        StringRule minLength = minLength(3);

        StringValidator validator = new StringValidator();
        validator.addRule(notEmpty);
        validator.addRule(minLength);

        String proof = null;
        List<String> errors = validator.validate(proof);

        if (errors.isEmpty())
            System.out.println("String ist gültig");
        else {
            System.out.println("Fehler");
            errors.forEach(System.out::println);
        }
    }

    public static StringRule minLength(int lenth) {
        return value -> {
            if (value != null && value.length() < lenth)
                return "Wert muss mindestens " + lenth + " Zeichen lang sein";
            return null;
        };
    }
}
