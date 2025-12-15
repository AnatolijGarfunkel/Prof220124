package stream_basics.emp;

import stream_basics.person.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmpTester {

    public static void main(String[] args) {
        List<Emp> emps = List.of(
                new Emp("Max Petrov", 22, "programmer"),
                new Emp("Ivan Peregudov", 33, "analyst"),
                new Emp("Semen Dezhnev", 55, "manager"),
                new Emp("Katerina Drogova", 31, "programmer"),
                new Emp("Oleg Petrov", 19, "intern"),
                new Emp("Nicolas Spivakov", 23, "analyst"),
                new Emp("Boris Moiseev", 48, "manager"),
                new Emp("Alex Reingard", 33, "analyst"),
                new Emp("Olga Filimonova", 27, "programmer")
        );

        // сохраните в список и распечатайте всех работников с возрастом больше 41
        List<Emp> empList;
//        empList = emps.stream()
//                .filter(emp -> emp.getAge() > 41)
//                .toList();
//
//        System.out.println(empList);

        // распечатайте только имена всех программистов
        // Olga Filimonova -> Olga
//        List<String> programmersByFirstName = emps.stream()
//                .filter(emp -> "programmer".equals(emp.getPosition()))
//                .map(emp -> emp.getName().split(" ")[0])
//                .toList();
//
//        System.out.println(programmersByFirstName);

        // посчитайте количество аналитиков
        // max() min() average() count()
//        long analysts = emps.stream()
//                .filter(emp -> "analyst".equals(emp.getPosition()))
//                .count();
//
//        System.out.println(analysts);

        // найдите самого молодого работника
//        Emp emp = emps.stream()
//                .min(Comparator.comparingInt(Emp::getAge))
//                .orElse(null);
//
//        System.out.println(emp);

        // посчитайте количество уникальных позиций 4
//        long numberOfPositions = emps.stream()
//                .map(Emp::getPosition)
//                .distinct()
//                .count();
//
//        System.out.println(numberOfPositions);

        // распечатайте 3 самых опытных работников - кто старше всех
//        List<Emp> oldest3emps = emps.stream()
//                .sorted(Comparator.comparing(Emp::getAge).reversed())
//                .limit(3)
//                .toList();
//
//        System.out.println("Oldest 3emps:" +  oldest3emps);

        // убедитесь что все работники старше 18 лет
//        boolean allOver18 = emps.stream()
//                .allMatch(emp -> emp.getAge() > 18);
//
//        System.out.println(allOver18);

        // распечатайте фамилии всех женщин - зачанчиваются на 'a'
//        List<String> allFemaleNames = emps.stream()
//                .filter(emp -> emp.getName().charAt(emp.getName().length() - 1) == 'a')
//                .map(emp -> emp.getName().split(" ")[1])
//                .toList();
//
//        System.out.println(allFemaleNames);

        // найдите средний возраст
        // mapToDouble()
        // average()
//        double averageAge = emps.stream()
//                .mapToDouble(Emp::getAge)
//                .average()
//                .orElse(0.0);
//
//        System.out.println("Average age: " + averageAge);

        // посчитайте количество программистов-мужчин - имя не оканчивается на 'a'
//        long numberOfMaleProgrammers = emps.stream()
//                .filter(emp -> "programmer".equals(emp.getPosition()))
//                .filter(emp -> emp.getName().charAt(emp.getName().length() - 1) != 'a')
//                .count();
//
//        System.out.println(numberOfMaleProgrammers);

        // распечатайте всех работников, отсортировав их по профессии и по возрасту
//        List<Emp> sortedByPositionAndAge = emps.stream()
//                .sorted(Comparator.comparing(Emp::getPosition).thenComparing(Emp::getAge))
//                .toList();
//
//        for (Emp emp : sortedByPositionAndAge)
//            System.out.println(emp);

        // посчитайте сумму возрастов работников
//        int sumOfAges = emps.stream()
//                .mapToInt(Emp::getAge)
//                .sum();
//
//        System.out.println(sumOfAges);

        // сохраните в лист
        // Max, Petrov, programmer, Ivan, Peregudov, analyst
        // stream<Emp> -> Stream.of(...)
//        List<String> listOfEmployesWithPosition = emps.stream()
//                .flatMap(emp -> Stream.of(emp.getName().split(" ")[0], emp.getName().split(" ")[1], emp.getPosition()))
//                .toList();
//
//        System.out.println(listOfEmployesWithPosition);


        // разделите всех работников на 2 группы - старше 40 лет (true) и младше
        // Map<Boolean, List<Emp>>
//        Map<Boolean, List<Emp>> over40 = emps.stream()
//                .collect(Collectors.partitioningBy(emp -> emp.getAge() > 40));
//
//        for (Map.Entry<Boolean, List<Emp>> entry : over40.entrySet()) {
//            System.out.println(entry.getKey());
//            for (Emp emp : entry.getValue())
//                System.out.println(emp);
//        }

        // сгруппируйте работников по профессии
        // Map<String, List<Emp>>
//        Map<String, List<Emp>> mapOfEmpByPosition = emps.stream()
//                .collect(Collectors.groupingBy(Emp::getPosition));
//
//        for (Map.Entry<String, List<Emp>> entry : mapOfEmpByPosition.entrySet()) {
//            System.out.println(entry.getKey());
//            for (Emp emp : entry.getValue())
//                System.out.println(emp);
//        }

        // распечатайте профессии и количество работников в них
        // Map<String, Integer>
//        Map<String, Long> numberOfEmpsByPosition = emps.stream()
//                .collect(
//                        Collectors.groupingBy(
//                                Emp::getPosition,
//                                Collectors.counting()
//                        )
//                );
//
//        for (Map.Entry<String, Long> entry : numberOfEmpsByPosition.entrySet())
//            System.out.println(entry.getKey() + " : " + entry.getValue());

        // создайте Map<имя фамилия, возраст>
//        Map<String, Integer> mapOfNameAndAge = emps.stream()
//                .collect(Collectors.toMap(
//                        Emp::getName,
//                        Emp::getAge
//                ));
//
//        for (Map.Entry<String, Integer> entry : mapOfNameAndAge.entrySet())
//            System.out.println(entry.getKey() + " - " + entry.getValue());



    }
}














































