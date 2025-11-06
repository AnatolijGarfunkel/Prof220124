package lesson_10;

import java.util.*;

public class ComparatorTester {

    public static void main(String[] args) {

        List<String> groups = new ArrayList<>(
                Arrays.asList(
                        "Ramones", "Aerosmith", "Rolling Stones", "Beatles", "Roxette", "INXS"
                )
        );

        System.out.println(groups);
        groups.sort((o1, o2) -> o1.length() - o2.length());
        System.out.println(groups);
    }
}
