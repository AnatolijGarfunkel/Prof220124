package stream_basics.person;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main_Person {

    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Anna", 25, "Berlin", 3200),
                new Person("Bernd", 17, "Hamburg", 0),
                new Person("Clara", 32, "Berlin", 4500),
                new Person("Dirk", 15, "München", 0),
                new Person("Eva", 40, "Hamburg", 5100),
                new Person("Fritz", 29, "Berlin", 3800)
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

//        double avgAdultIncome = people.stream()
//                .filter(person -> person.getAge() >= 18)
//                .mapToDouble(Person::getIncome)
//                .average()
//                .orElse(0);
//
//        System.out.println(avgAdultIncome);

//        Map<String, Double> avgAdultIncomeByCity = people.stream()
//                .filter(person -> person.getAge() >= 18)
//                .collect(Collectors.groupingBy(Person::getCity, Collectors.averagingDouble(Person::getIncome)));
//
//        System.out.println(avgAdultIncomeByCity);

//        List<String> top3AdultNamesByIncomeDesc = people.stream()
//                .filter(person -> person.getAge() >= 18)
//                .sorted(Comparator.comparing(Person::getIncome).reversed())
//                .map(Person::getName)
//                .limit(3)
//                .toList();
//
//        System.out.println(top3AdultNamesByIncomeDesc);

//        Map<String, List<String>> highEarningAdultsByCity = people.stream()
//                .filter(p -> p.getAge() >= 18 && p.getIncome() >= 4000)
//                .collect(Collectors.groupingBy(Person::getCity, Collectors.mapping(Person::getName, Collectors.toList())));
//
//        System.out.println(highEarningAdultsByCity);

//        double totalTaxBerlinAdults = people.stream()
//                .filter(person -> "Berlin".equals(person.getCity()) && person.getAge() >= 18)
//                .mapToDouble(person -> person.getIncome() * 0.3)
//                .sum();
//
//        System.out.println(totalTaxBerlinAdults);

//        DoubleSummaryStatistics adultIncomeStats = people.stream()
//                .filter(person -> person.getAge() >= 18)
//                .collect(Collectors.summarizingDouble(Person::getIncome));
//
//        System.out.println(adultIncomeStats);

//        boolean hasGoodAdultIncomeStats = adultIncomeStats.getCount() >= 3 && adultIncomeStats.getAverage() > 3000;

//        List<String> adultNamesBerlin = people.stream()
//                .peek(person -> System.out.println(person.getName() + " : " + person.getAge()))
//                .filter(person -> person.getAge() >= 18 && "Berlin".equals(person.getCity()))
//                .peek(person -> System.out.println(person.getName() + " : " + person.getIncome()))
//                .map(Person::getName)
//                .toList();

//        Map<String, Double> incomeByName = people.stream()
//                .collect(Collectors.toMap(
//                        Person::getName,
//                        Person::getIncome
//                ));
//
//        System.out.println("Income by name: " + incomeByName);

//        Map<String, Double> totalIncomeByCity = people.stream()
//                .collect(Collectors.toMap(
//                        Person::getCity,
//                        Person::getIncome,
//                        Double::sum
//                ));
//
//        System.out.println("Total income by city: " + totalIncomeByCity);

//        Map<String, Double> incomeByName = people.stream()
//                .collect(Collectors.toMap(
//                        Person::getName,
//                        Person::getIncome
//                ));
//
//        System.out.println(incomeByName);

//        Map<String, Double> totalIncomeByCity = people.stream()
//                .collect(Collectors.toMap(
//                        Person::getCity,
//                        Person::getIncome,
//                        Double::sum
//                ));
//
//        System.out.println(totalIncomeByCity);

//        Map<String, Person> richestPersonByCity = people.stream()
//                .collect(Collectors.toMap(
//                        Person::getCity,
//                        Function.identity(),
//                        (a, b) -> a.getIncome() > b.getIncome() ? a : b
//                ));
//
//        for (Map.Entry<String, Person> entry : richestPersonByCity.entrySet()) {
//            System.out.println(entry.getKey() + " - " + entry.getValue().getName() + " - " + entry.getValue().getIncome());
//        }

//        Map<String, Person> personByName = people.stream()
//                .collect(Collectors.toMap(
//                        Person::getName,
//                        Function.identity()
//                ));

//        Map<String, List<String>> top2AdultNamesByIncomePerCity = people.stream()
//                .filter(p -> p.getAge() >= 18)
//                .collect(Collectors.groupingBy(
//                        Person::getCity,
//                        Collectors.collectingAndThen(
//                                Collectors.toList(),
//                                list -> list.stream()
//                                        .sorted(Comparator.comparing(Person::getIncome).reversed())
//                                        .limit(2)
//                                        .map(Person::getName)
//                                        .toList()
//                        ))
//                );
//
//        System.out.println(top2AdultNamesByIncomePerCity);

//        Map<String, Person> richestPersonByCity = people.stream()
//                .collect(Collectors.toMap(
//                                Person::getCity,
//                                Function.identity(),
//                                (a, b) -> a.getIncome() >= b.getIncome() ? a : b
//                        )
//                );
//
//        for (Map.Entry<String, Person> entry : richestPersonByCity.entrySet()) {
//            System.out.println(entry.getKey() + " - " + entry.getValue().getName() + " - " + entry.getValue().getIncome());
//        }

//        double totalIncomeWithCollect = people.stream()
//                .collect(
//                        () -> new double[1],
//                        (acc, person) -> acc[0] += person.getIncome(),
//                        (acc1, acc2) -> acc1[0] += acc2[0]
//                )[0];
//
//        System.out.println(totalIncomeWithCollect);

//        Map<String, Long> personsPerCity = people.stream()
//                .collect(
//                        Collectors.groupingBy(
//                                Person::getCity,
//                                Collectors.counting()
//                        )
//                );
//
//        System.out.println(personsPerCity);

//        Map<String, Double> sumIncomeByCity = people.stream()
//                .collect(
//                        Collectors.groupingBy(
//                                Person::getCity,
//                                Collectors.summingDouble(Person::getIncome)
//                        )
//                );
//
//        System.out.println(sumIncomeByCity);



    }
}














































