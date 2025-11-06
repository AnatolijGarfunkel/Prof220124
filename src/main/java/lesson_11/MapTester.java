package lesson_11;

import java.util.HashMap;
import java.util.Map;

public class MapTester {

    public static void main(String[] args) {
        Map<String, String> capitals = new HashMap<>();
        capitals.put("Germany", "Berlin");
        capitals.put("France", "Paris");
        capitals.put("UK", "London");
        System.out.println(capitals);

        String country = "Estonia";
        String capital = "Tallinn";
        boolean estonia = capitals.containsKey(country);
        boolean tallinn = capitals.containsValue(capital);

        Map<String, Integer> townLength = new HashMap<>();

        for (String data : capitals.keySet()) {
            townLength.put(data, capitals.get(data).length());
        }

        System.out.println(townLength);
    }
}















































