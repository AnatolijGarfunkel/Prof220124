package lesson_04.animals;

public class BigDog extends Dog{

    public BigDog(String name) {
        super(name);
    }

    @Override
    public void greets() {
        System.out.println("WOOF!");
    }

    @Override
    public void greets(Dog d) {
        System.out.println("WOOOF!!!");
    }

    public void greets(BigDog bigDog) {
        System.out.println("WOOOOOOFFF!!!");
    }


}
