package lesson_12_functional_interfaces.first_task;

public record ValidationResult(

        String key,

        ValidationStatus status,

        String message
) {
    public boolean isOk() {
        return status == ValidationStatus.OK;
    }
}
