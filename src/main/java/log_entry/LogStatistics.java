package log_entry;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LogStatistics {

    public static long countByLevel(List<LogEntry> entries, String level) {
        if (level == null || level.isBlank())
            return 0;
        long count = entries.stream()
                .filter(entry -> entry.level().equalsIgnoreCase(level))
                .count();

        return count;
    }

    public static Map<String, Long> countAllLevels(List<LogEntry> entries) {
        Map<String, Long> levelCount = entries.stream()
                .collect(Collectors.groupingBy((LogEntry::level), Collectors.counting()));

        return levelCount;
    }

    public static List<LogEntry> errorsOnly(List<LogEntry> entries) {
        List<LogEntry> errors = entries.stream()
                .filter(entry -> "ERROR".equalsIgnoreCase(entry.level()))
                .toList();

        return errors;
    }

    public static List<String> messagesForLevel(List<LogEntry> entries, String level) {
        List<String> messages = entries.stream()
                .filter(entry -> entry.level().equalsIgnoreCase(level))
                .map(LogEntry::message)
                .toList();

        return messages;
    }
}
