package field_validator.string_validator_function;

import field_validator.records.Person;

import java.util.List;

public class Main_PersonValidation {

    public static void main(String[] args) {

        List<Person> persons = List.of(
                new Person("Clara", "200"),
                new Person("marcus", null),
                new Person("DaNa", "25"),
                new Person(null, ""),
                new Person("a", "2020"),
                new Person("BOb", "abc")
        );

        String field;
        String value;

        StringValidator nameValidator = new StringValidator();
        nameValidator.addRule(StringRules.beginsWithUp());
        nameValidator.addRule(StringRules.endsWithLow());
        nameValidator.addRule(StringRules.minLength(2));

        StringValidator ageValidator = new StringValidator();
        ageValidator.addRule(StringRules.maxLength(3));
        ageValidator.addRule(StringRules.onlyDigits());
        ageValidator.addRule(StringRules.maxAge(130));


        for (Person person : persons) {
            System.out.println("\n" + person);
            field = "name";
            value = person.name();
            List<String> nameErrors = nameValidator.validate(value);

            if (nameErrors.isEmpty())
                System.out.println(field + ": " + value + "\n:OK");
            else {
                System.out.println(field + ": " + value);
                for (String error : nameErrors)
                    System.out.println(error);
            }

            field = "age";
            value = person.age();
            List<String> ageErrors = ageValidator.validate(value);

            if (ageErrors.isEmpty())
                System.out.println(field + ": " + value + "\n:OK");
            else {
                System.out.println(field + ": " + value);
                for (String error : ageErrors)
                    System.out.println(error);
            }
        }
    }
}
















































