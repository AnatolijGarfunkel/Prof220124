package lesson_05.implementation;

import java.util.Arrays;
import java.util.Iterator;

public class TestArrayList implements MyList {

    private int position = 0;

    private int[] array = new int[10];


    public int getArrayLength() {
        return array.length;
    }


    public TestArrayList(int... array) {
        for (int data : array)
            add(data);
    }


    @Override
    public int size() {
        return position;
    }

    @Override
    public void add(int value) {

        if (position == array.length)
            increase();

        array[position] = value;
        position++;
    }

    private void increase() {
        int size = (int) (position * 1.6);
        array = Arrays.copyOf(array, size);
    }

    @Override
    public void add(int index, int value) {
        if (proofIndex(index)) {
            if (index == position) {
                increase();
            }
            for (int i = position; i >= index; i --) {
                array[i] = array[i - 1];
            }
            array[index] = value;
            position ++;
        }
        else
            System.out.println("index passt nicht.");
    }

    @Override
    public int get(int index) {
        if (proofIndex(index))
            return array[index];
        System.out.println("ArrayIndexOutOfBounds - " + index);
        return Integer.MAX_VALUE;
    }

    private boolean proofIndex(int index) {
        return index < position & index >= 0;
    }

    @Override
    public void remove(int index) {
        if (proofIndex(index)) {
            for (int i = index; i < position - 1; i++) {
                array[i] = array[i + 1];
            }
            position--;
        } else
            System.out.println("index passt nicht!");
    }

    @Override
    public void set(int index, int value) {
        if (proofIndex(index)) {
            array[index] = value;
        } else {
            System.out.println("Index passt nicht!");
        }
    }

    @Override
    public boolean contains(int value) {
        for (int data : array) {
            if (data == value)
                return true;
        }
        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            int position = 0;

            @Override
            public boolean hasNext() {
                return position < size();
            }

            @Override
            public Integer next() {
                return array[position ++];
            }

            @Override
            public void remove() {
                TestArrayList.this.remove(-- position);
            }
        };
    }

    @Override
    public Iterator<Integer> backward() {
        return new Iterator<>() {
            int position = size();
            @Override
            public boolean hasNext() {
                return position > 0;
            }

            @Override
            public Integer next() {
                return array[-- position];
            }
        };
    }

    @Override
    public Iterator<Integer> smallToBig() {
        return new SmallToBigIterator();
    }

    private class SmallToBigIterator implements Iterator<Integer> {

        private int [] data = new int[size()];
        private int position = 0;

        public SmallToBigIterator() {
            System.arraycopy(array, 0, data, 0, size());
            Arrays.sort(data);
        }

        @Override
        public boolean hasNext() {
            return position < size();
        }

        @Override
        public Integer next() {
            return data[position ++];
        }
    }

    @Override
    public String toString() {

        String string = "[";

        for (int i = 0; i <= position; i++) {
            if (i == position - 1) {
                string += array[i];
                break;
            }
            string += array[i] + ", ";
        }
        string += "]";

        return string;
    }
}









































