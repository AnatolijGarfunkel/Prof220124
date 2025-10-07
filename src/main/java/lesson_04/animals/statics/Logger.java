package lesson_04.animals.statics;

public class Logger {

    private static Logger instance;

    private int test = 0;

    public Logger() {

    }

    public static Logger getInstance() {
        if (instance == null)
            instance = new Logger();

        return instance;
    }

    public void log(String s) {
        System.out.println("Logger: " + s);
    }

    public void setTest(int test) {
        this.test = test;
    }

    public int getTest() {
        return test;
    }
}
