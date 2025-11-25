package field_validator.records;

import java.util.List;

public record FieldErrors(String field, String value, List<String> messages) {

    public void print() {
        if (messages().isEmpty())
            System.out.println(field() + ": " + value + ": OK");
        else
            for (String message : messages())
                System.out.println(field() + ": " + value + ": " + message);
    }
}
