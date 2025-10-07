package lesson_05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTester {

    public static void main(String[] args) {

        List<String> capitals = new ArrayList<>();

        capitals.add("Viena");
        capitals.add("Amsterdam");
        capitals.add("Prague");
        capitals.add(1, "Riga");

        List<Integer> a = Arrays.asList(4, 2, 3);
        List<Integer> b = Arrays.asList(4, 5, 3);

        List<Boolean> booleans = compare(a, b);

        System.out.println("result: " + booleans);

    }

    public static List<Boolean> compare(List<Integer> a, List<Integer> b) {

        List<Boolean> result = new ArrayList<>();

        for (int i = 0; i < a.size(); i ++) {
            boolean equals = a.get(i).equals(b.get(i));
            result.add(equals);
        }

        return result;
    }

    public static String maxLength(List<String> list) {
        String result = list.getFirst();

        for (String data: list) {
            if (data.length() > result.length())
                result = data;
        }

        return result;
    }


    public static List<Integer> concat(List<Integer> a, List<Integer> b) {

        List<Integer> result = new ArrayList<>();

        result.addAll(a);
        result.addAll(b);

        return result;
    }
}
