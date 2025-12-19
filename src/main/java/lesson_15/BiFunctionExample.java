package lesson_15;

import java.util.function.BiFunction;

public class BiFunctionExample {

    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> sum = Integer::sum;
        BiFunction<Integer, Integer, Integer> product = (a, b) -> a * b;
        BiFunction<Integer, Integer, Integer> subtract = (a, b) -> a - b;
        BiFunction<Integer, Integer, Integer> division = (a, b) -> a / b;

        System.out.println(sum.apply(10, 5));
        System.out.println(product.apply(10, 5));
        System.out.println(subtract.apply(10, 5));
        System.out.println(division.apply(10, 5));

    }
}
