package field_validator.records;

import java.util.List;

public record Person_Errors(Person person, List<FieldErrors> fieldErrors) {

    public void print() {
        person.print();
        for (FieldErrors fieldError : fieldErrors)
            fieldError.print();
    }
}
