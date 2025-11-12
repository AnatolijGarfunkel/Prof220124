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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Pair getNext() {
        return next;
    }

    public void setNext(Pair next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return key + " : " + value;
    }
}
