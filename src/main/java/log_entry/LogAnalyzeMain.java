package log_entry;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LogAnalyzeMain {

    public static void main(String[] args) {

        Path path = Path.of("log");
        List<LogEntry> entries = new ArrayList<>();

        try {
            entries = LogFileReader.readLogFile(path);
        } catch (IOException e) {
            System.err.println("Fehler beim Lesen der Datei: " + e.getMessage());
            return;
        }

        Map<String, Long> stringLongMap = LogStatistics.countAllLevels(entries);
        System.out.println(stringLongMap);

        long info = LogStatistics.countByLevel(entries, "info");
        System.out.println("info: " + info);

        List<String> messages = LogStatistics.messagesForLevel(entries, "info");
        System.out.println(messages);

        List<LogEntry> errors = LogStatistics.errorsOnly(entries);
        System.out.println(errors);
    }
}
