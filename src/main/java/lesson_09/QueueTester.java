package lesson_09;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueTester  {

    public static void main(String[] args) {

        List<String> list = List.of("eins", "zwei", "drei", "vier");

        Queue<String> bankQueue = new LinkedList<>(list);

        while (!bankQueue.isEmpty())
            System.out.printf(bankQueue.remove() + " ");
    }
}
