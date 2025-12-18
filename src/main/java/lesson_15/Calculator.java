package lesson_15;

@FunctionalInterface
public interface Calculator {

    int sum(int a, int b);

    default void printHello() {
        System.out.println("Hello from Calculator");
    }
}
