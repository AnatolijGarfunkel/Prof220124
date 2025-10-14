package lesson_06;

import lesson_05.implementation.MyList;
import lesson_05.implementation.TestArrayList;

import java.util.*;

public class Tester {

    public static void main(String[] args) {

        int [] data = {5, 7, -2, 2, 9, - 5, 3};

        MyList myList = new TestArrayList(data);

        System.out.println(myList);

        ListIterator<Integer> iterator = myList.listIterator();

        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next.equals(-2))
                iterator.add(-100);
        }

        System.out.println(myList);
    }
}

































