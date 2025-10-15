package lesson_09;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeTester {

    public static void main(String[] args) {

        String string = "Allnla";
        string = string.toLowerCase();

        boolean palindrome = isPalindrome(string);

        if (palindrome)
            System.out.println("Is Palindrome!");
        else
            System.out.println("Is Not!");


    }

    public static boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> list = new ArrayDeque<>();

        for (char data: chars) {
            list.add(data);
        }

        while (list.size() > 1) {
            Character first = list.pollFirst();
            Character last = list.pollLast();
            if (!first.equals(last))
                return false;
        }

        return true;
    }
}
