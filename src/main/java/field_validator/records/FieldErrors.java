package field_validator.records;

import java.util.List;

public record FieldErrors(String field, String value, List<String> messages) {
}
