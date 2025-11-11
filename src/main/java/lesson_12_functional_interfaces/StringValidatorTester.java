package lesson_12_functional_interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StringValidatorTester {

    public static void main(String[] args) {

        StringValidator notEmpty = text -> text.isEmpty() ? Optional.of("Leer") : Optional.empty();
        StringValidator beginsWithBig = text -> !Character.isUpperCase(text.charAt(0)) ? Optional.of("faengt mit klein") : Optional.empty();
        StringValidator mitFive = text -> text.length() >= 5 ? Optional.of("mehr als 5") : Optional.empty();
        StringValidator conBang = text -> text.contains("!") ? Optional.of("enthaelt !") : Optional.empty();

        String text = "wuppertal!";
        List<StringValidator> validators = List.of(
                notEmpty,
                beginsWithBig,
                mitFive,
                conBang
        );

        StringValidator combined = combine(validators);

        Optional<String> optional = validateAll(validators, text);
        if (optional.isEmpty())
            System.out.println("ist Ok");
        else
            System.out.println(optional.get());

        List<String> errors = collectErrors(validators, text);
        System.out.println(errors);

        System.out.println("combined: " + combined.validate(text));
    }

    public static Optional<String> validateAll(List<StringValidator> validators, String text) {
        for (StringValidator validator : validators) {
            Optional<String> optional = validator.validate(text);
            if (optional.isPresent())
                return optional;
        }
        return Optional.empty();
    }

    public static List<String> collectErrors(List<StringValidator> validators, String text) {
        List<String> errorsList = new ArrayList<>();

        for (StringValidator validator : validators) {
            Optional<String> optional = validator.validate(text);
            if (optional.isPresent())
                errorsList.add(String.valueOf(optional));
        }

        return errorsList;
    }

    public static StringValidator combine(List<StringValidator> validators) {
        return text -> {
            for (StringValidator validator : validators) {
                Optional<String> optional = validator.validate(text);
                if (optional.isPresent())
                    return optional;
            }
            return Optional.empty();
        };
    }
}















































