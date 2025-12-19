package lesson_15;

public class AnonymousExample {

    public static void main(String[] args) {

        Printer hallo = new Printer() {
            @Override
            public void print() {
                System.out.println("Hello");
            }
        };

        PrinterAdditional halloAdd = new PrinterAdditional() {
            @Override
            public void printGreetings() {
                System.out.println("Hello");
            }

            @Override
            public void printBye() {
                System.out.println("Bye!");
            }
        };

        halloAdd.printGreetings();
        halloAdd.printBye();
    }
}
