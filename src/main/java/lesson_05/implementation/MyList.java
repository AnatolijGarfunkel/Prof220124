package lesson_05.implementation;

import java.util.Iterator;

public interface MyList extends Iterable<Integer> {

    int size();

    void add(int value);

    void add(int index, int value);

    int get(int index);

    void remove(int index);

    void set(int index, int value);

    boolean contains(int value);

    Iterator<Integer> iterator();

    Iterator<Integer> backward();

    Iterator<Integer> smallToBig();
}
