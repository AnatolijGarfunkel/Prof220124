package stream_basics;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorTester {

    public static void main(String[] args) {

        List<String> names = List.of("Masha", "Alexander", "Sveta", "Vlad", "Alice", "Xenia");

        // соберем все элементы в Map<длина, список элементов>
//        Map<Integer, List<String>> namesByLength = names.stream()
//                .collect(Collectors.groupingBy(String::length));
//
//        for (Map.Entry<Integer, List<String>> entry : namesByLength.entrySet()) {
//            System.out.println(entry.getKey());
//            for (String name : entry.getValue())
//                System.out.println(name);
//        }

        // groupingBy создает мапу по ключу из лямбды
        // соберем все элементы в Map<длины, количества элементов с такой длиной>
//        Map<Integer, Long> lengthAndCount = names.stream()
//                .collect(Collectors.groupingBy(
//                        String::length,
//                        Collectors.counting()
//                ));
//
//        for (Map.Entry<Integer, Long> entry : lengthAndCount.entrySet())
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//
//        Map<Integer, Integer> lengthAndCountEntry = names.stream()
//                .collect(Collectors.groupingBy(String::length))
//                .entrySet().stream()
//                .map(pair -> new AbstractMap.SimpleEntry<>(pair.getKey(), pair.getValue().size()))
//                .collect(Collectors.toMap(
//                        AbstractMap.SimpleEntry::getKey,
//                        AbstractMap.SimpleEntry::getValue
//                ));
//
//        for (Map.Entry<Integer, Integer> entry : lengthAndCountEntry.entrySet())
//            System.out.println(entry.getKey() + " : " + entry.getValue());

    }
}














































