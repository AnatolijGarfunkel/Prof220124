package lesson_15;

import java.util.function.BiConsumer;

public class BiConsumerExample {

    public static void main(String[] args) {

        BiConsumer<Integer, Integer> sum = (a, b) -> System.out.println(a + b);
        sum.accept(10, 5);

        BiConsumer<Integer, Integer> mult = (a, b)  -> System.out.println(a * b);
        mult.accept(10, 5);

    }
}
