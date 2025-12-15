package stream_basics;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.*;

public class IntStreamsBasics {

    public static void main(String[] args) {

//        IntStream s1 = IntStream.of(1, 2, 3);
//
//        int[] arr = {1, 2, 3};
//        IntStream s2 = Arrays.stream(arr);
//
//        List<Integer> list = s2
//                .boxed()
//                .toList();
//
//        System.out.println(Arrays.toString(arr));
//
//        IntStream range = IntStream.range(1, 5);
//        List<Integer> integers = range.boxed().toList();
//
//        System.out.println(integers);
//
//        OptionalDouble average = IntStream.of(1, 2, 3).average();
//        double v = average.orElse(0);
//
//        int sumDivisibleBy3 = IntStream.rangeClosed(1, 100)
//                .filter(e -> e % 3 == 0)
//                .sum();
//
//
//        long factorial20 = LongStream.rangeClosed(1, 20)
//                .reduce(1, (x, y) -> x * y);
//
//
//        double avgSquare = LongStream.rangeClosed(1, 100)
//                .map(e -> e * e)
//                .average()
//                .orElse(0);

        List<Integer> numbers = List.of(3, 7, 12, 18, 21, 5, 30, 11, 19);

//        int sumOfSquareOddsOver10 = numbers.stream()
//                .filter(integer -> integer % 2 != 0 && integer > 10)
//                .map(integer -> integer * integer)
//                .reduce(Integer::sum)
//                .orElse(0);
//
//        System.out.println(sumOfSquareOddsOver10);
//
//        sumOfSquareOddsOver10 = numbers.stream()
//                .filter(integer -> integer % 2 != 0 && integer > 10)
//                .mapToInt(integer -> integer * integer)
//                .sum();
//
//        System.out.println(sumOfSquareOddsOver10);

//        int productOfEvenUnder20 = numbers.stream()
//                .filter(integer -> integer < 20 && integer % 2 == 0)
//                .reduce(1, Math::multiplyExact);
//
//        System.out.println(productOfEvenUnder20);

//        OptionalInt maxSquareOfOddOver10 = numbers.stream()
//                .filter(n -> n % 2 != 0 && n > 10)
//                .mapToInt(n -> n * n)
//                .max();
//
//        System.out.println(maxSquareOfOddOver10);

        List<String> words = List.of("alpha", "beta", "gamma", "delta", "epsilon");

//        int totalLengthOfWordsStartingWithVowel = words.stream()
//                .filter(word -> word.startsWith("a") || word.startsWith("e") || word.startsWith("i") || word.startsWith("o") || word.startsWith("u"))
//                .mapToInt(String::length)
//                .sum();

//        List<String> longUppercaseSorted = words.stream()
//                .filter(word -> word.length() >= 5)
//                .map(String::toUpperCase)
//                .sorted()
//                .toList();
//
//        System.out.println(longUppercaseSorted);

//        String longUppercaseJoined = words.stream()
//                .filter(word -> word.length() >= 5)
//                .map(String::toUpperCase)
//                .sorted()
//                .collect(Collectors.joining(", "));
//
//        System.out.println(longUppercaseJoined);


//        Optional<String> longestWord = words.stream()
//                .reduce((a, b) -> a.length() > b.length() ? a : b);
//
//        System.out.println(longestWord.orElse(""));

        List<String> sentences = List.of(
                "Java Streams sind praktisch",
                "Streams machen Spaß",
                "map und filter"
        );

//        long wordCount = sentences.stream()
//                .flatMap((new Function<String, Stream<? extends String>>() {
//                    @Override
//                    public Stream<? extends String> apply(String stream) {
//                        return Arrays.stream(stream.split(" "));
//                    }
//                }))
//                .count();
//
//        System.out.println(wordCount);

//        long letterCount = sentences.stream()
//                .flatMapToInt(string -> string.chars().filter(Character::isLetter))
//                .count();
//
//        System.out.println(letterCount);

//        List<Integer> processed = numbers.stream()
//                .filter(n -> n >= 10 && n <= 25)
//                .map(n -> n * 2)
//                .filter(n -> n % 3 == 0)
//                .sorted()
//                .toList();

        List<String> values = List.of("10", "abc", "25", "-3", "x5", "40", "0");

//        int sumOfPositiveInts = values.stream()
//                .filter(v -> v.chars().allMatch(Character::isDigit))
//                .mapToInt(Integer::parseInt)
//                .sum();
//
//        System.out.println(sumOfPositiveInts);

//        OptionalDouble averageOfValidInts = values.stream()
//                .filter(v -> v.matches("^-?\\d+$"))
//                .mapToInt(Integer::parseInt)
//                .average();
//
//        System.out.println(averageOfValidInts);

//        List<Integer> evenNumbers = numbers.stream()
//                .collect(
//                        ArrayList::new,
//                        (integers, integer) -> {
//                            if (integer % 2 == 0)
//                                integers.add(integer);
//                        },
//                        List::addAll
//                );
//
//        System.out.println(evenNumbers);

//        int sumEvenWithCollect = numbers.stream()
//                .collect(
//                        () -> new int[1],
//                        (ints, integer) -> {
//                            if (integer % 2 == 0)
//                                ints[0] += integer;
//                        },
//                        (ints1, ints2) -> ints1[0] += ints2[0]
//                )[0];
//
//        System.out.println(sumEvenWithCollect);



    }
}














































