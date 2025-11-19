package lesson_12_functional_interfaces.first_task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FT_StringValidatorTester {

    public static void main(String[] args) {

        FT_StringValidator notEmpty = text -> text.isEmpty() ? Optional.of("Leer") : Optional.empty();
        FT_StringValidator beginsWithBig = text -> !Character.isUpperCase(text.charAt(0)) ? Optional.of("faengt mit klein") : Optional.empty();
        FT_StringValidator mitFive = text -> text.length() >= 5 ? Optional.of("mehr als 5") : Optional.empty();
        FT_StringValidator conBang = text -> text.contains("!") ? Optional.of("enthaelt !") : Optional.empty();

        String text = "wuppertal!";
        List<FT_StringValidator> validators = List.of(
                notEmpty,
                beginsWithBig,
                mitFive,
                conBang
        );

        FT_StringValidator combined = combine(validators);

        Optional<String> optional = validateAll(validators, text);
        if (optional.isEmpty())
            System.out.println("ist Ok");
        else
            System.out.println(optional.get());

        List<String> errors = collectErrors(validators, text);
        System.out.println(errors);

        System.out.println("combined: " + combined.validate(text));
    }

    public static Optional<String> validateAll(List<FT_StringValidator> validators, String text) {
        for (FT_StringValidator validator : validators) {
            Optional<String> optional = validator.validate(text);
            if (optional.isPresent())
                return optional;
        }
        return Optional.empty();
    }

    public static List<String> collectErrors(List<FT_StringValidator> validators, String text) {
        List<String> errorsList = new ArrayList<>();

        for (FT_StringValidator validator : validators) {
            Optional<String> optional = validator.validate(text);
            if (optional.isPresent())
                errorsList.add(String.valueOf(optional));
        }

        return errorsList;
    }

    public static FT_StringValidator combine(List<FT_StringValidator> validators) {
        return text -> {
            for (FT_StringValidator validator : validators) {
                Optional<String> optional = validator.validate(text);
                if (optional.isPresent())
                    return optional;
            }
            return Optional.empty();
        };
    }
}















































