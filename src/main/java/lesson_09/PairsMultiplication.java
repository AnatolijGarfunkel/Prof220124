package lesson_09;

import java.util.*;

public class PairsMultiplication {

    public static void main(String[] args) {
        List<Integer> integerList = new LinkedList<>(List.of(2, 7, 5, 12, 14));
        int proof = 60;

        boolean calculate = calculate(integerList, proof);
        System.out.println("Is " + calculate);
    }

    public static boolean calculate(List<Integer> ints, int proof) {
        ints.sort(Integer::compareTo);
        Deque<Integer> list = new LinkedList<>(ints);
        int first = list.removeFirst();
        int last = list.removeLast();
        while (!list.isEmpty()) {
            int result = first * last;
            if (result == proof)
                return true;
            if (result < proof)
                first = list.removeFirst();
            if (result > proof)
                last = list.removeLast();
        }
        return false;
    }
}
