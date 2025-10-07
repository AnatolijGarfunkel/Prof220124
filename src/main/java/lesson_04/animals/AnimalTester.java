package lesson_04.animals;

public class AnimalTester {

    public static void main(String[] args) {

        BigDog barbos = new BigDog("Barbos");
        Cat kitty = new Cat("Kitty");

        Animal [] animals = {barbos, kitty};

        animals[0].greets();
        animals[1].greets();
    }
}
