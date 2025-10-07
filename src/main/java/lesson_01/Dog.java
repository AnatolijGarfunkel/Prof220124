package lesson_01;

public class Dog {

    private String breed;

    private int age;

    private String color;

    private String name;

    public Dog() {

    }

    public Dog(String name) {
        this.name = name;
    }

    public Dog(String breed, int age, String color, String name) {
        this.breed = breed;
        this.age = age;
        this.color = color;
        this.name = name;
    }

    void bark() {
        System.out.println("Dog " + name + " barking");
    }

    void info() {
        System.out.println("Dog " + name + ", age: " + age + ", bread: " + breed);
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
