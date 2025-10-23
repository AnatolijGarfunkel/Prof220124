package lesson_09;

import java.util.*;

public class BalancedParentheses {

    public static void main(String[] args) {
        List<String> s = List.of(
                "{}[]",
                "{[]()}",
                "[}",
                "{{{)}]",
                "{()()[[()]()]}",
                "}{"
        );

        for (String data : s)
            System.out.println(data + ": " + isBalanced(data));
    }

    public static boolean isBalanced(String s) {
        Stack<Character> chars = new Stack<>();
        List<Character> symbols = List.of('{', '[', '(');

        for (char data : s.toCharArray()) {
            if (symbols.contains(data)) {
                chars.push(data);
            } else if (
                    (!chars.isEmpty()) &&
                            (
                                    (data == '}' && chars.peek() == '{')
                                            ||
                                    (data == ']' && chars.peek() == '[')
                                            ||
                                    (data == ')' && chars.peek() == '(')
                            )
            ) {
                chars.pop();
            }
        }

        return chars.isEmpty();
    }
}















































