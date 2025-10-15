package lesson_07;

import java.util.Iterator;

public class Tester {

    public static void main(String[] args) {

        MyLinkedList myLinkedList = new MyLinkedListImpl();

        myLinkedList.add(0);
        myLinkedList.add(1);
        myLinkedList.add(2);

        System.out.println("Size: " + myLinkedList.size());
        System.out.println(myLinkedList);

        myLinkedList.addFirst(9);


        System.out.println("Size: " + myLinkedList.size());
        System.out.println(myLinkedList);

    }
}
