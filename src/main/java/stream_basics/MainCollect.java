package stream_basics;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class MainCollect {

    public static void main(String[] args) {

        List<String> letters = List.of("a", "b","c","d","e","f","g","h","i");

        StringBuilder builder = letters.stream()
                .collect(
                        StringBuilder::new,
                        (stringBuilder, str) -> stringBuilder.append(str).append(", "),
                        (s1, s2) -> s1.append(", ")
                );

        System.out.println(builder.toString());

//        StringBuilder s1 = new  StringBuilder();
//        StringBuilder s2 = new StringBuilder();
//        s1.append(letters.getFirst());
//        s2.append(letters.getLast());
//
//        System.out.println(s1.toString());
//        System.out.println(s2.toString());
//
//        s1.append(", ").append(s2);
//        System.out.println(s1.toString());
    }
}
















































