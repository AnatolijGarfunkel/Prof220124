package lesson_06;

import java.util.Iterator;

public class ArrayIterator implements Iterator<Integer> {

    int [] data;
    int position = 0;

    public ArrayIterator(int [] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return position < data.length;
    }

    @Override
    public Integer next() {
        return data[position ++];
    }
}
