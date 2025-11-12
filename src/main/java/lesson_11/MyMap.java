package lesson_11;

public interface MyMap {

    void put(String k, String v);

    String get(String k);

    String remove(String k);

    boolean contains(String k);

    int size();
}
