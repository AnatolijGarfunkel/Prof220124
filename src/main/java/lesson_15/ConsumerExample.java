package lesson_15;

import lesson_15.basefi.Student;

import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import java.util.stream.IntStream;

public class ConsumerExample {

    public static void main(String[] args) {

        Consumer<String> stringConsumer = (s) -> System.out.println(s);
        stringConsumer.accept("Hello");

        Consumer<String> stringConsumer2 = (s) -> {
            char[] charArray = s.toCharArray();
            for (char c : charArray) {
                System.out.println(c);
            }
        };
        stringConsumer2.accept("Java");

        Consumer<Integer> integerConsumer = (i) -> IntStream.rangeClosed(1, i).forEach(System.out::println);
        integerConsumer.accept(5);

        Consumer<Student> studentInfo = s -> System.out.println(s.getName() + " - " + s.getAge());

        Student alex = new Student("Alex", 15);
        studentInfo.accept(alex);

        IntConsumer intConsumer = i -> System.out.println("int: " + i);
        LongConsumer longConsumer  = i -> System.out.println("long: " + i);
        DoubleConsumer doubleConsumer =  i -> System.out.println("double: " + i);
        intConsumer.accept(15);
        longConsumer.accept(16);
        doubleConsumer.accept(17.7);
    }
}
