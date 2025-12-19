package stream_basics;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamBasics {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);

        Optional<Integer> reduce = numbers.stream()
                .filter(integer -> integer % 2 == 0)
                .reduce(Integer::sum);

        int result = reduce.orElse(0);

        List<String> strings = List.of("a", "bb", "ccc");

        Optional<String> string = strings.stream()
                .reduce((e1, e2) -> e1 + e2);

        String s = string.orElse("");
        System.out.println("result: " + s);

        List<String> words = List.of("Java", "Streams", "sind", "praktisch");

        int totalLength = words.stream()
                .mapToInt(String::length)
                .sum();

        System.out.println("result: " + totalLength);

        totalLength = words.stream()
                .map(String::length)
                .reduce(Integer::sum)
                .orElse(0);

        System.out.println("result: " + totalLength);

        long countLongWords = words.stream()
                .filter(e -> e.length() > 5)
                .count();

        System.out.println("Result: " + countLongWords);

        List<String> list = words.stream()
                .filter(e -> e.toLowerCase().startsWith("s"))
                .map(String::toUpperCase)
                .toList();

        boolean match = words.stream()
                .anyMatch(e -> e.length() > 10);

        boolean allAtLeastThree = words.stream()
                .allMatch(e -> e.length() >= 3);

        boolean noneStartsWithZ = words.stream()
                .noneMatch(word -> word.toLowerCase().startsWith("z"));

        List<Integer> length = words.stream()
                .map(String::length)
                .distinct()
                .sorted()
                .toList();

        String joined = words.stream()
                .collect(Collectors.joining(", "));

        List<String> reversedWords = words.stream()
                .map(w -> new StringBuilder(w).reverse().toString())
                .toList();


        List<List<Integer>> nested = List.of(
                List.of(1, 2),
                List.of(3, 4, 5),
                List.of(6)
        );

        List<Integer> flat = nested.stream()
                .flatMap(List::stream)
                .toList();

    }
}















































