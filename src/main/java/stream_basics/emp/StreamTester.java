package stream_basics.emp;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class StreamTester {

    public static void main(String[] args) {
        List<Integer> years = List.of(2000, 2022, 2021, 2027, 2021, 2000);

        String[] names = {"Alexander", "Max", "Xenia", "Maria"};
        // отфильтруйте по наличию буквы x
        // переведите в верхний регистр
        // распечатайте каждый прошедший поток элемент forEach
//        Arrays.stream(names)
//                .filter(name -> name.contains("x"))
//                .map(String::toUpperCase)
//                .forEach(System.out::println);

        // превратите поток из имен в строку
        // "Alexander", "Max", "Xenia", "Maria" ->
        // "Alexander, Max, Xenia, Maria"

        String result;
//        result = Arrays.stream(names)
//                .reduce(
//                        new BinaryOperator<String>() {
//                            @Override
//                            public String apply(String a, String b) {
//                                return a + ", " + b;
//                            }
//                        }
//                )
//                .orElse("");
//
//        System.out.println(result);

        int[] numbers = {2, 4, 5, 8, 3};

        // найдите в numbers максимальное значение используя reduce
        int max;

//        max = Arrays.stream(numbers)
//                .max()
//                .orElse(0);
//
//        System.out.println(max);

        // найдите самое длинное имя из names
        // используя потоковый max

        result = Arrays.stream(names)
                .reduce((a, b) -> a.length() >= b.length() ? a : b)
                .orElse("");

        System.out.println(result);
    }
}














































