package lesson_05.implementation;

import java.util.Iterator;

public class Test {

    public static void main(String[] args) {

        int [] array = {0, 1, 2, 3};

        TestArrayList list = new TestArrayList(array);


        System.out.println("size(position): " + list.size());
        System.out.println("array.length: " + list.getArrayLength());
        System.out.println(list);
        System.out.println("");

        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext())
            System.out.printf(iterator.next() + " ");

    }
}
