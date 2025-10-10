package lesson_06;

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

        Iterator<String> iterator = capitals.iterator();

        while (iterator.hasNext()) {
            if (iterator.next().startsWith("B"))
                iterator.remove();
        }

        System.out.println(capitals);
    }
}

































