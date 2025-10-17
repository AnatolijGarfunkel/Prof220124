package lesson_09;

import java.util.*;

public class BalancedParentheses {

    public static void main(String[] args) {
        String s = "}{";
        boolean balanced = isBalanced(s);
        System.out.println("Is balanced: " + balanced);
    }

    public static boolean isBalanced(String s) {
        if (s.length() % 2 != 0)
            return false;

        List<Character> right = List.of('}', ']', ')');

        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        List<Character> chars = new LinkedList<>();

        for (Character data : arr) {
            chars.add(data);
        }

        stack.push(chars.getFirst());
        chars.removeFirst();
        Character peek = stack.peek();

        if (right.contains(peek))
            return false;

        for (Character data : chars) {
            stack.push(data);


            switch (peek) {
                case '{':
                    if (stack.peek().equals('}')) {
                        stack.pop();
                        stack.pop();
                    }
                    if (!stack.empty() && (stack.peek().equals(']') || stack.peek().equals(')')))
                        return false;
                    break;
                case '[':
                    if (stack.peek().equals(']')) {
                        stack.pop();
                        stack.pop();
                    }
                    if (!stack.empty() && (stack.peek().equals('}') || stack.peek().equals(')')))
                        return false;
                    break;
                case '(':
                    if (stack.peek().equals(')')) {
                        stack.pop();
                        stack.pop();
                    }
                    if (!stack.empty() && (stack.peek().equals(']') || stack.peek().equals('}')))
                        return false;
                    break;
            }
            stack.push(data);
            peek = stack.peek();
        }
        return true;
    }
}















































