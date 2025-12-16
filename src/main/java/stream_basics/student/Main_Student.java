package stream_basics.student;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main_Student {

    public static void main(String[] args) {

        List<Student> students = List.of(
                new Student("Michael", "Svetlov", 24),
                new Student("Alexander", "Svetlov", 28),
                new Student("Daria", "Petrovskaya", 19),
                new Student("Maria", "Drobysheva", 19),
                new Student("Max", "Pavlov", 24)
        );

        // соберите не повторяющиеся фамилии студентов в контейнер по
        // возрастанию
//        List<String> unigueLastNames = students.stream()
//                .map(Student::getLastName)
//                .distinct()
//                .sorted()
//                .toList();
//
//        for (String unigueLastName : unigueLastNames)
//            System.out.println(unigueLastName);
//
//        TreeSet<String> unigueNameTreeSet = students.stream()
//                .map(Student::getLastName)
//                .collect(
//                        Collectors.toCollection(
//                                TreeSet::new
//                        )
//                );
//
//        System.out.println();
//        for (String unigueLastName : unigueNameTreeSet)
//            System.out.println(unigueLastName);

        // сгруппируйте студентов по возрасту
        // Map<Integer, List<Student>>
//        Map<Integer, List<Student>> studentsByAge = students.stream()
//                .collect(Collectors.groupingBy(Student::getAge));
//
//        for (Map.Entry<Integer, List<Student>> entry : studentsByAge.entrySet()) {
//            System.out.println(entry.getKey());
//            for (Student student : entry.getValue())
//                System.out.println(student);
//        }

        // разделите студентов по гендеру
        // считая что фамилии оканчивающееся на 'a' женские
        // Map<Boolean, List<Student>>
        // true - женские
        Map<Boolean, List<Student>> isStudentFemale = students.stream()
                .collect(Collectors.partitioningBy(
                        student -> student.getLastName().endsWith("a")
                ));

        for (Map.Entry<Boolean, List<Student>> entry : isStudentFemale.entrySet()) {
            System.out.println(entry.getKey());
            for (Student student : entry.getValue())
                System.out.println(student);
        }



    }
}















































