package lesson_06;

import lesson_05.implementation.MyList;
import lesson_05.implementation.TestArrayList;

import java.util.*;

public class Tester {

    public static void main(String[] args) {

        List<String> capitals = new ArrayList<>(
                Arrays.asList(
                        "Bogota",
                        "Brazilia",
                        "Buenos-Aires",
                        "Santiago"
                )
        );

        Iterator<String> iterator = capitals.iterator();

        List<Integer> integers = new ArrayList<>(
                Arrays.asList(-2, 1, 2, 3, 4)
        );

        Iterator<Integer> integerIterator = integers.iterator();

        Set<String> rivers = Set.of("Vistula", "Rein", "Danube");

        Iterator<String> stringIterator = rivers.iterator();

        MyList myList = new TestArrayList(1, 2, 3);

        myList.iterator();
    }
}

































