package lesson_09;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class ReversePolish {

    public static void main(String[] args) {

        String toCalculate = "3 4 + 2 - 6 *";
        int result = reversePolishCalculator(toCalculate);
        System.out.println("Result: " + result);

    }

    public static int reversePolishCalculator(String toCalculate) {
        String[] chars = toCalculate.split(" ");
        Queue<String> calc = new ArrayDeque<>(Arrays.asList(chars));

        int first = Integer.parseInt(calc.remove());

        while (!calc.isEmpty()) {
            int second = Integer.parseInt(calc.remove());
            String operand = calc.remove();
            switch (operand) {
                case "+":
                    first += second;
                    break;
                case "-":
                    first -= second;
                    break;
                case "*":
                    first *= second;
                    break;
                case "/":
                    first /= second;
                    break;
            }
        }

        return first;
    }
}
