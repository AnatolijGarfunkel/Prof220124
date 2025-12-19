package lesson_15;

public class CalculatorExample {

    public static void main(String[] args) {

        Calculator calculator = (a, b) -> a + b;
        System.out.println(calculator.sum(10, 5));
        calculator.printHello();

        CalculatorTwo multiplier = (a, b) -> a * b;
        System.out.println(multiplier.mult(10, 5));

        Calculator impl = new CalculatorImpl();
        System.out.println(impl.sum(10, 5));
    }
}
