package log_entry;

public record LogEntry(String timestamp, String level, String message) {

    public static LogEntry parse(String line) {
        if (line == null || line.isBlank())
            throw new IllegalArgumentException("Zeile ist leer oder null");

        String[] parts = line.split(";", 3);
        if (parts.length > 3)
            throw new IllegalArgumentException("Ungültiges Logformat" + line);

        String timestamp = parts[0].trim();
        String level = parts[1].trim();
        String message = parts[2].trim();

        return new LogEntry(timestamp, level, message);
    }
}
