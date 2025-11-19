package lesson_12_functional_interfaces.first_task;

public record FT_ValidationResult(

        String key,

        FT_ValidationStatus status,

        String message
) {
    public boolean isOk() {
        return status == FT_ValidationStatus.OK;
    }
}
