package lesson_05.implementation;

public interface MyList {

    int size();

    void add(int value);

    void add(int index, int value);

    int get(int index);

    void remove(int index);

    void set(int index, int value);

    boolean contains(int value);

}
