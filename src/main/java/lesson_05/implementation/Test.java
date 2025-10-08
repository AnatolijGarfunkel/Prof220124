package lesson_05.implementation;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        TestArrayList list = new TestArrayList();

        for (int i = 1; i <= 10; i ++) {
            list.add(i);
        }

        System.out.println("size(position): " + list.size());
        System.out.println("array.length: " + list.getArrayLength());
        System.out.println(list);

        boolean contains = list.contains(13);
        if (contains)
            System.out.println("element " + 4 + " ist vorhanden.");
        else
            System.out.println("element " + 13 + " ist nicht vorhanden.");

    }
}
