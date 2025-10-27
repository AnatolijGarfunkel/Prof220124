package lesson_09;

import java.util.*;

public class HomeWork {

    public static void main(String[] args) {

        String word = "allaana";

        Set<Character> result = unique(word);
        System.out.println("result: " + result);
    }

    public static Set<Character> unique(String word) {
        Set<Character> set = new HashSet<>();

        for (Character data: word.toCharArray())
            set.add(data);

        return set;
    }
}
