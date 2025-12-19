package lesson_15;

import lesson_15.basefi.Product;
import lesson_15.basefi.Student;

import java.util.*;
import java.util.function.*;

public class ExampleApp {

    static int id = 0;

    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student("Oleg", 20),
                new Student("Jack", 30),
                new Student("James", 40),
                new Student("Alex", 15),
                new Student("Max", 18)
        );

        List<Product> products = Arrays.asList(
                new Product("Apple", 70, true),
                new Product("Banana", 30, false),
                new Product("Lemon", 45, true),
                new Product("Pineapple", 60, true),
                new Product("Watermelon", 40, true),
                new Product("Carrot", 55, false)
        );

        Function<Student, String> nameOfStudent = Student::getName;
        students.forEach(student -> System.out.println(nameOfStudent.apply(student)));

        Predicate<Product> inStockAndMoreThan50 = product -> product.isInStock() && product.getPrice() > 50;

        System.out.println(
                products.stream()
                        .filter(inStockAndMoreThan50)
                        .toList()
        );

        System.out.println(PredicateExample.filter(products, inStockAndMoreThan50));

        Consumer<Product> productInfo = product -> System.out.println(product.getTitle() + " | " + product.getPrice() + " | " + product.isInStock());

        products.stream()
                .filter(inStockAndMoreThan50)
                .forEach(productInfo);

        students.stream()
                .sorted((a, b) -> Integer.compare(a.getAge(), b.getAge()))
                .forEach(System.out::println);

        System.out.println(filterStudent(students, student -> student.getAge() >= 18));
        System.out.println(filterStudent(students, student -> student.getName().startsWith("A")));

        List<Predicate<Product>> predicates = Arrays.asList(
                Product::isInStock,
                product -> product.getPrice() < 50,
                product -> product.getTitle().contains("e")
        );

        System.out.println(filterProducts(products, predicates));

        Function<Student, String> studentsName = Student::getName;
        Function<String, String> nameToUpper = String::toUpperCase;
        Function<String, Integer> nameLength = String::length;

        Function<Student, Integer> length = studentsName.andThen(nameToUpper).andThen(nameLength);

        System.out.println(length.apply(students.getFirst()));


        Supplier<Integer> intSupplier = () -> ++id;
        System.out.println(intSupplier.get());
        System.out.println(intSupplier.get());
        System.out.println(intSupplier.get());
        System.out.println(intSupplier.get());
        System.out.println(intSupplier.get());

        Map<String, BiFunction<Integer, Integer, Integer>> map = new HashMap<>();
        map.put("sum", Integer::sum);
        map.put("sub", (a, b) -> a - b);
        map.put("mul", (a, b) -> a * b);
        map.put("div", (a, b) -> a / b);

        String operation = "sum";

        try {
            System.out.println(map.get(operation).apply(20, 5));
        } catch (Exception e) {
            System.out.println("division with 0 is not allowed!");
        }

    }

    public static List<Product> filterProducts(List<Product> products, List<Predicate<Product>> predicates) {
        List<Product> filteredProducts = new ArrayList<>();

        Predicate<Product> productPredicate = predicates.stream()
                .reduce(predicate -> true, Predicate::and);

        for (Product product : products)
            if (productPredicate.test(product))
                filteredProducts.add(product);

        return filteredProducts;
    }

    public static List<Student> filterStudent(List<Student> students, Predicate<Student> predicate) {
        List<Student> filteredStudents = new ArrayList<>();

        for (Student student : students)
            if (predicate.test(student))
                filteredStudents.add(student);

        return filteredStudents;
    }
}