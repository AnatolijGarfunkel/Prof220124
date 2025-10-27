package lesson_09;

import java.util.*;

public class HomeWork {

    public static void main(String[] args) {

        String string = "один раз это один раз но только раз";

        Map<String, List<Integer>> map = vorhanden(string);
        System.out.println(map);
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

    public static Map<String, List<Integer>> vorhanden(String string) {
        Map<String, List<Integer>> map = new LinkedHashMap<>();
        List<String> list = List.of(string.split(" "));
        Set<String> set = new LinkedHashSet<>(list);

        for (String data: set) {
            List<Integer> count = new LinkedList<>();
            for (int i = 0; i < list.size(); i ++) {
                if (data.equals(list.get(i)))
                    count.add(i);
            }
            map.put(data, count);
        }
        return map;
    }
}
