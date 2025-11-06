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

        List<Cat> cats = new ArrayList<>(
                Arrays.asList(
                        new Cat("Amir", 3),
                        new Cat("Murzik", 2),
                        new Cat("Pushok", 4),
                        new Cat("Junior", 1),
                        new Cat("Alex", 2),
                        new Cat("Zack", 2)
                )
        );

        Comparator<Cat> ageNameComparator = (o1, o2) -> {
            int age = o1.getAge() - o2.getAge();
            int name = o1.getName().compareTo(o2.getName());
            return age == 0 ? name : age;
        };

        cats.sort(ageNameComparator);
        System.out.println(cats);
    }
}
