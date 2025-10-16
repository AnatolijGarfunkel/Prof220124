package lesson_09;

import java.util.ArrayDeque;
import java.util.Queue;

public class ReversePolish {

    public static void main(String[] args) {

        String toCalculate = "3 4 + 2 - 6 *";
        int result = reversePolishCalculator(toCalculate);
        System.out.println("Result: " + result);

    }

    public static int reversePolishCalculator(String toCalculate) {
        char[] chars = toCalculate.toCharArray();
        Queue<Character> calc = new ArrayDeque<>();

        for (Character data: chars) {
            if (!data.equals(' '))
                calc.add(data);
        }

        int first = Character.getNumericValue(calc.remove());

        while (!calc.isEmpty()) {
            int second = Character.getNumericValue(calc.remove());
            char operand = calc.remove();
            switch (operand) {
                case '+':
                    first += second;
                    break;
                case '-':
                    first -= second;
                    break;
                case '*':
                    first *= second;
                    break;
                case '/':
                    first /= second;
                    break;
            }
        }

        return first;
    }
}
