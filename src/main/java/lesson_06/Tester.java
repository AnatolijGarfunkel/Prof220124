package lesson_06;

import lesson_05.implementation.MyList;
import lesson_05.implementation.TestArrayList;

import java.util.*;

public class Tester {

    public static void main(String[] args) {

        List<String> capitals = new ArrayList<>(
                Arrays.asList(
                        "Bogota",
                        "Buenos-Aires",
                        "Santiago",
                        "Berlin",
                        "Paris"
                )
        );

        MyList myList = new TestArrayList(1, 3, -5, 7);

        Iterator<Integer> iterator = myList.iterator();

        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next < 0)
                iterator.remove();
        }

        System.out.println(myList);

    }
}

































