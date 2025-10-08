package lesson_05.implementation;

import java.util.Arrays;

public class TestArrayList implements MyList{

    private int position = 0;

    private int [] array = new int[10];




    public int getArrayLength() {
        return array.length;
    }


    @Override
    public int size() {
        return position;
    }

    @Override
    public void add(int value) {

        if (position < array.length) {
            array[position] = value;
            position ++;
        }
        else {
            increase();
            add(value);
        }
    }

    private void increase() {
        int size = (int) (position * 1.6);
        array = Arrays.copyOf(array, size);
    }

    @Override
    public void add(int index, int value) {

        if (position < array.length) {
            for (int i = position; i > index; i --) {
                array[i] = array[i - 1];
            }
            array[index] = value;
            position ++;
        }
        else {
            increase();
            add(index, value);
        }
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

    }

    @Override
    public void set(int index, int value) {
        if (proofIndex(index)) {
            array[index] = value;
        }
        else {
            System.out.println("Index passt nicht!");
        }
    }

    @Override
    public boolean contains(int value) {
        for (int data: array) {
            if(data == value)
                return true;
        }
        return false;
    }

    @Override
    public String toString() {

        String string = "[";

        for (int i = 0; i <= position; i ++) {
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









































