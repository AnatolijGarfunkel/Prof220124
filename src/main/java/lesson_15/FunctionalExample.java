package lesson_15;

public class FunctionalExample {

    public static void main(String[] args) {
        Printer printerAnonymous = new Printer() {
            @Override
            public void print() {
                System.out.println("Hello");
            }
        };

        Printer printerLambda = () -> System.out.println("Hello");

        printerAnonymous.print();
        printerLambda.print();
    }
}
