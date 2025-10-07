package lesson_02;

public class B extends A{

    @Override
    public void hello() {
        System.out.println("Hello from B!");
    }

    @Override
    protected void word() {
        System.out.println("From parent A: ");
        super.word();
        System.out.println("Word from B!");
    }
}
