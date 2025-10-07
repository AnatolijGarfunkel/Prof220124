package lesson_02.person;

public class Person {

    private String name;

    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void introduce() {
        System.out.println("name: " + name + "\nage:  " + age);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
