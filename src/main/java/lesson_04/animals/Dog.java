package lesson_04.animals;

public class Dog extends Animal{

    public Dog(String name) {
        super(name);
    }

    @Override
    public void greets() {
        System.out.println("Woof!");
    }

    public void greets(Dog d) {
        System.out.println("Woooof!");
    }

    final public void jump() {
        System.out.println("Dog is jumping!");
    }
}
