package lesson_02.animals;

public class FlyingFish implements Swimmer, Flyer{

    @Override
    public void fly() {
        System.out.println("I'm flying!!!");
    }

    @Override
    public void swim() {
        System.out.println("I'm swimming!!!");
    }
}
