package lesson_09;

import java.util.*;

public class HomeWork {

    public static void main(String[] args) {

        Set<Integer> set = new HashSet<>(Set.of(-1, 12, 3, 4, -8, -2));

        removeNegative(set);

        System.out.println("result " + set);
    }

    public static Set<Character> unique(String word) {
        Set<Character> set = new HashSet<>();

        for (Character data: word.toCharArray())
            set.add(data);

        return set;
    }

    public static void removeNegative(Set<Integer> set) {

        set.removeIf(integer -> integer < 0);
    }
}
