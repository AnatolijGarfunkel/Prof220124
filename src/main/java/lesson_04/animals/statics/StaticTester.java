package lesson_04.animals.statics;

public class StaticTester {

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        logger.log("Test");

        String dbUrl = Constants.getDbUrl();

        System.out.println("DB_URL: " + dbUrl);
    }
}
