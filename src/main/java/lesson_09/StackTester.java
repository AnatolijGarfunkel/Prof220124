package lesson_09;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StackTester {

    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();

        List<String> list = List.of("Dima", "Max", "Darya");


        String phrase = "однажды в студеную зимнюю пору я из лесу вышел";

        List<String> words = Arrays.asList(phrase.split(" "));

        for (String data: words)
            stack.push(data);

        while (!stack.empty()) {
            System.out.printf(stack.pop() + " ");
        }
    }
}
