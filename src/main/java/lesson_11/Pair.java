package lesson_11;

public class Pair {

    private String key;

    private String value;

    private Pair next;

    public Pair(String key, String value, Pair next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return key + " : " + value;
    }
}
