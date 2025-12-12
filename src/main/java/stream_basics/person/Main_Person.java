package stream_basics.person;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main_Person {

    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Anna", 25, "Berlin",   3200),
                new Person("Bernd", 17, "Hamburg", 0),
                new Person("Clara", 32, "Berlin",  4500),
                new Person("Dirk", 15, "München",  0),
                new Person("Eva", 40, "Hamburg",   5100),
                new Person("Fritz", 29, "Berlin",  3800)
        );

//        List<String> adultNames = people.stream()
//                .filter(person -> person.getAge() >= 18)
//                .map(Person::getName)
//                .toList();
//
//        System.out.println("result: " + adultNames);
//
//        List<String> adultNamesByAgeDesc = people.stream()
//                .filter(person -> person.getAge() >= 18)
//                .sorted(Comparator.comparing(Person::getAge).reversed())
//                .map(Person::getName)
//                .toList();
//
//        System.out.println("result: " + adultNamesByAgeDesc);
//
//        Map<String, List<Person>> peopleByCity = people.stream()
//                .collect(Collectors.groupingBy(Person::getCity));
//
//        for (Map.Entry<String, List<Person>> entry : peopleByCity.entrySet()) {
//            System.out.println("\n" + entry.getKey());
//            List<Person> persons = entry.getValue();
//            for (Person person : persons)
//                System.out.println(person.getName());
//        }
//
//        Map<String, Long> numberOfAdultByCity = people.stream()
//                .filter(person -> person.getAge() >= 18)
//                .collect(Collectors.groupingBy(Person::getCity, Collectors.counting()));
//
//        System.out.println(numberOfAdultByCity);
//
//
//        Map<String, Double> averageAgeByCity = people.stream()
//                .collect(Collectors.groupingBy(Person::getCity, Collectors.averagingInt(Person::getAge)));
//
//        System.out.println(averageAgeByCity);
//
//        Optional<Person> oldestPerson = people.stream()
//                .max(Comparator.comparingInt(Person::getAge));
//
//        Person p = oldestPerson.orElse(null);
//
//        System.out.println(p.getName() + " : " + p.getAge());
//
//        Optional<Person> youngestAdultInBerlin = people.stream()
//                .filter(person -> person.getCity().equals("Berlin") && person.getAge() >= 18)
//                .min(Comparator.comparing(Person::getAge));
//
//        youngestAdultInBerlin.ifPresent(person -> System.out.println(person.getName() + " : " + person.getCity() + " : " + person.getAge()));
//
//        Map<String, List<String>> adultNamesByCity = people.stream()
//                .filter(person -> person.getAge() >= 18)
//                .collect(Collectors.groupingBy(Person::getCity, Collectors.mapping(Person::getName, Collectors.toList())));
//
//        System.out.println(adultNamesByCity);
//
//        Map<Boolean, List<Person>> partitionByAdult = people.stream()
//                .collect(Collectors.partitioningBy(person -> person.getAge() >= 18));
//
//        for (Map.Entry<Boolean, List<Person>> pair : partitionByAdult.entrySet()) {
//            System.out.println(pair.getKey());
//            for (Person person : pair.getValue()) {
//                System.out.println(person.getName());
//            }
//        }
//
//        Map<Boolean, List<Person>> partitionByAdultLoop = new HashMap<>();
//        partitionByAdultLoop.put(true, new ArrayList<>());
//        partitionByAdultLoop.put(false, new ArrayList<>());
//
//        for (Person person : people) {
//            if (person.getAge() >= 18) {
//                partitionByAdultLoop.get(true).add(person);
//            } else {
//                partitionByAdultLoop.get(false).add(person);
//            }
//        }
//
//        for (Map.Entry<Boolean, List<Person>> pair : partitionByAdultLoop.entrySet()) {
//            System.out.println(pair.getKey());
//            for (Person person : pair.getValue()) {
//                System.out.println(person.getName());
//            }
//        }


    }
}














































