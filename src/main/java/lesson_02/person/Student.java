package lesson_02.person;

public class Student extends Person{

    private int year;

    private String program;

    public Student(String name, int age) {
        super(name, age);
    }

    public Student(String name, int age, int year, String program) {
        super(name, age);
        this.year = year;
        this.program = program;
    }

    @Override
    public void introduce() {
        System.out.println("I'm a student " + getName());
    }
}
