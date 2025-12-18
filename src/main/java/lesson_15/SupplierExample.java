package lesson_15;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierExample {

    public static void main(String[] args) {
        Random random = new Random();
        Supplier<Double> supplier = random::nextDouble;
        for (int i = 1; i <= 5; i ++) {
            System.out.println(supplier.get());
        }
        Supplier<String> hello = () -> "Hello";
        System.out.println(hello.get());
    }
}
