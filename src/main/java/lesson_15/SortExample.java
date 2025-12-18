package lesson_15;

import lesson_15.basefi.Student;

import java.util.*;

public class SortExample {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Oleg", 20),
                new Student("Jack", 30),
                new Student("James", 40),
                new Student("Alex", 15),
                new Student("Max", 18)
        );

        System.out.println("Original: " + students);
        
        List<Student> students1 = new ArrayList<>(students);

        Collections.sort(
                students1,
                new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return Integer.compare(o1.getAge(), o2.getAge());
                    }
                }
        );

        System.out.println("By age (anonymous): " + students1);

        List<Student> students2 = new ArrayList<>(students);

        SortByAge sortByAge = new SortByAge();
        Collections.sort(students2, sortByAge);
        System.out.println("By age (class): " + students2);

        List<Student> students3 = new ArrayList<>(students);
        Collections.sort(
                students3,
                (a, b) -> a.getName().compareTo(b.getName())
        );
        System.out.println("By name (lambda): " + students3);
    }
}
