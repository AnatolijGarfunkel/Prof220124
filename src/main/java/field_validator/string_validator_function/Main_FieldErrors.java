package field_validator.string_validator_function;

import field_validator.records.FieldErrors;
import field_validator.records.Person;

import java.util.List;

public class Main_FieldErrors {

    public static void main(String[] args) {

        List<Person> persons = List.of(
                new Person("Clara", "200"),
                new Person("marcus", null),
                new Person("DaNa", "25"),
                new Person(null, ""),
                new Person("a", "2020"),
                new Person("BOb", "abc")
        );

        StringValidator nameValidator = StringValidatorBuilder.create()
                .configure(value -> value.length() < 2 ? "Wert muss mindestens " + 2 + " Zeichen lang sein." : null)
                .beginsWithUp()
                .endsWithLow()
                .build();

        StringValidator ageValidator = StringValidatorBuilder.create()
                .configure(value -> !value.chars().allMatch(Character::isDigit) ? "Wert darf nur Ziffern enthalten." : null)
                .configure(value -> value.length() > 3 ? "Wert darf höchstens " + 3 + " Zeichen lang sein." : null)
                .maxAge(130)
                .build();

        for (Person person : persons) {
            System.out.println("\n" + person);
            String field;
            String value;

            field = Person.class.getRecordComponents()[0].getName();
            value = person.name();
            List<String> nameErrors = nameValidator.validate(value);
            FieldErrors nameMessages = new FieldErrors(field, value, nameErrors);

            if (nameMessages.messages().isEmpty())
                System.out.println(nameMessages.field() + ": " + nameMessages.value() + ": OK");
            else {
                List<String> messages = nameMessages.messages();
                for (String message : messages)
                    System.out.println(nameMessages.field() + ": " + nameMessages.value() + ": " + message);
            }

            field = Person.class.getRecordComponents()[1].getName();
            value = person.age();
            List<String> ageErrors = ageValidator.validate(value);
            FieldErrors ageMessages = new FieldErrors(field, value, ageErrors);

            if (ageMessages.messages().isEmpty())
                System.out.println(ageMessages.field() + ":  " + ageMessages.value() + ": OK");
            else {
                List<String> messages = ageMessages.messages();
                for (String message : messages)
                    System.out.println(ageMessages.field() + ":  " + ageMessages.value() + ": " + message);
            }

        }
    }
}














































