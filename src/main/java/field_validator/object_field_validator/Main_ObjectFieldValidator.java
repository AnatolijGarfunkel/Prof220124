package field_validator.object_field_validator;

import field_validator.records.FieldErrors;
import field_validator.records.Person;
import field_validator.string_validator_function.StringValidatorBuilder;

import java.util.ArrayList;
import java.util.List;

public class Main_ObjectFieldValidator {

    public static void main(String[] args) {

        ObjectFieldValidator<Person> nameValidator = new ObjectFieldValidator<>("name", Person::name, StringValidatorBuilder.create()
                .beginsWithUp()
                .endsWithLow()
                .minLength(2)
                .build());

        ObjectFieldValidator<Person> ageValidator = new ObjectFieldValidator<>("age", Person::age, StringValidatorBuilder.create()
                .configure(value -> !value.chars().allMatch(Character::isDigit) ? "Wert darf nur Ziffern enthalten." : null)
                .configure(value -> value.length() > 3 ? "Wert darf höchstens " + 3 + " Zeichen lang sein." : null)
                .maxAge(130)
                .build());

        List<ObjectFieldValidator<Person>> validators = new ArrayList<>();
        validators.add(nameValidator);
        validators.add(ageValidator);


        List<Person> persons = List.of(
                new Person("Clara", "200"),
                new Person("marcus", null),
                new Person("DaNa", "25"),
                new Person(null, ""),
                new Person("a", "2020"),
                new Person("Martin", "37"),
                new Person("BOb", "abc")
        );

        for (Person person : persons) {
            System.out.println("\n" + person);

            for (int i = 0; i < Person.class.getDeclaredMethods().length - 4; i++) {
                ObjectFieldValidator<Person> validator = validators.get(i);
                FieldErrors fieldErrors = validator.validateObject(person);

                if (fieldErrors.messages().isEmpty())
                    System.out.println(fieldErrors.field() + ": " + fieldErrors.value() + ": OK");
                else {
                    List<String> messages = fieldErrors.messages();
                    for (String message : messages)
                        System.out.println(fieldErrors.field() + ": " + fieldErrors.value() + ": " + message);
                }
            }
        }
    }
}















































