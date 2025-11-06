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

        System.out.println("\nentrySet");
        for (Map.Entry<String, String> pair : capitals.entrySet()) {
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }

        Map<Integer, String> fruits = new HashMap<>(
                Map.of(
                        89, "Banana",
                        67, "Grapes",
                        52, "Apple",
                        41, "Kiwi",
                        100, "Pear"
                )
        );

        fruits.entrySet()
                .stream()
                .filter(entry -> entry.getKey() > 50)
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));

        
    }
}















































