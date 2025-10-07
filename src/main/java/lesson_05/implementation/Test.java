package lesson_05.implementation;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        TestArrayList list = new TestArrayList();

        for (int i = 0; i <= 9; i ++) {
            list.add(i);
        }

        System.out.println("size(position): " + list.size());
        System.out.println("array.length: " + list.getArrayLength());
        System.out.println(list);

        list.set(-1, -1);

        System.out.println("size(position): " + list.size());
        System.out.println("array.length: " + list.getArrayLength());
        System.out.println(list);

    }
}
