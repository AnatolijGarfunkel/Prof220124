package log_entry;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LogFileReader {

    public static List<LogEntry> readLogFile(Path path) throws IOException {

        List<LogEntry> entries = new ArrayList<>();
        try (Stream<String> lines = Files.lines(path)) {
            lines
                    .filter(line -> !line.isBlank())
                    .forEach(
                            line -> {
                                try {
                                    LogEntry parse = LogEntry.parse(line);
                                    entries.add(parse);
                                }
                                catch (IllegalArgumentException e) {
                                    //
                                }
                            }
                    );
        }

        return entries;
    }
}
