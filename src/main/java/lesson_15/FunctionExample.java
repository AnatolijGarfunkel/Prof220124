package lesson_15;

import lesson_15.basefi.Student;

import java.util.function.Function;

public class FunctionExample {

    public static void main(String[] args) {
        Function<Integer, Double> half = (a) -> a / 2.0;
        System.out.println(half.apply(10));

        Function<String, String> hello = string -> "Hello".equals(string) ? "Привет" : string;
        System.out.println(hello.apply("Hello"));
        System.out.println(hello.apply("Java"));

        Student alex = new Student("Alex", 15);
        Function<Student, String> studentsName = student -> student.getName();
        System.out.println(studentsName.apply(alex));

        Function<String, Integer> length = (s) -> s.length();

        Function<Student, Integer> studentsNameLength = studentsName.andThen(length);
        System.out.println(studentsNameLength.apply(alex));
    }
}
