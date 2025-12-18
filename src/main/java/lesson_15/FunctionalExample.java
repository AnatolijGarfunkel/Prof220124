package lesson_15;

import lesson_15.basefi.Student;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FunctionalExample {

    public static void main(String[] args) {
        Printer printerAnonymous = new Printer() {
            @Override
            public void print() {
                System.out.println("Hello Anonymous");
            }
        };

        Printer printerLambda = () -> System.out.println("Hello Lambda");

        printerAnonymous.print();
        printerLambda.print();

        List<Student> students = Arrays.asList(
                new Student("Oleg", 20),
                new Student("Jack", 30),
                new Student("James", 40),
                new Student("Alex", 15),
                new Student("Max", 18)
        );

        System.out.println("Before: " + students);

        Collections.sort(
                students,
                new  Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return Integer.compare(o1.getAge(), o2.getAge());
                    }
                }
        );

        System.out.println("After age (anonymous): " + students);

        Collections.sort(
                students,
                (a, b) -> a.getName().compareTo(b.getName())
        );

        System.out.println("After name (lambda): " + students);
    }
}
