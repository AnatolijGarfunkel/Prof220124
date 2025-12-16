package stream_basics;

import stream_basics.order.Order;
import stream_basics.order.OrderItem;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class FlatMapTester {

    public static void main(String[] args) {

        List<List<String>> names = List.of(
                List.of("Masha", "Alexander"),
                List.of("Sveta", "Vlad", "Alice", "Xenia")
        );

        // соберите все эти имена в list String и распечатайте его
        List<String> listOfNames = names.stream()
                .flatMap(Collection::stream)
                .toList();

        for (String name : listOfNames)
            System.out.println(name);

        // разбейте все эти имена на отдельные буквы
        // соберите их в лист и распечатайте
        // "".split("") даст String []
        int[] array = names.stream()
                .flatMap(Collection::stream)
                .flatMapToInt(name -> Arrays.stream(name.chars().toArray()))
                .toArray();

        for (int c : array)
            System.out.println((char) c);

        List<String> chars = names.stream()
                .flatMap(Collection::stream)
                .flatMap(name -> Arrays.stream(name.split("")))
                .toList();

        for (String s : chars)
            System.out.println(s);

        // сделаем
        // Masha, Alexander, Sveta, Vlad, Alice, Xenia ->
        // Masha, MASHA, Alexander, ALEXANDER, Sveta, SVETA, ...
        List<String> namesWithUpper = names.stream()
                .flatMap(Collection::stream)
                .flatMap(name -> Stream.of(name, name.toUpperCase()))
                .toList();

        for(String name : namesWithUpper)
            System.out.println(name);

        // преобразуйте поток список списков в поток длин имен букв
        // желательно за одну операцию flatMap
        // names -> 5, 9, 5, 4, 5, 5
        List<Integer> lengthOfNames = names.stream()
                .flatMap(name -> name.stream().map(String::length))
                .toList();

        for (Integer length : lengthOfNames)
            System.out.println(length);

        Order grocery = new Order(
                new OrderItem("mango", 2, 1.6),
                new OrderItem("apples", 3, 0.99),
                new OrderItem("sprite", 1, 1.5)
        );

        Order utility = new Order(
                new OrderItem("water", 104, 0.3),
                new OrderItem("electricity", 201, 0.38)
        );

        List<Order> orders = List.of(grocery, utility);
        // посчитайте из orders суммарные затраты
        // stream(Order) -> stream(OrderItem)
        // mapToDouble
        // sum / reduce
        double sum = orders.stream()
                .flatMap(order -> order.getItems().stream())
                .mapToDouble(item -> item.getQuantity() * item.getUnitPrice())
                .sum();

        System.out.println(sum);

    }
}














































