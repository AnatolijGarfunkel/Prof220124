package lesson_04.animals.statics;

public class Constants {

    private static final String DB_URL = "oracle:10.3.2.1:8080";

    public static String getDbUrl() {
        return DB_URL;
    }
}
