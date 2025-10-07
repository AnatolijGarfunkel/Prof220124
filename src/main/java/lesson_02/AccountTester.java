package lesson_02;

public class AccountTester {

    public static void main(String[] args) {

        Account first = new Account("01", "first", 20);
        Account second = new Account("02", "second", 30);

        System.out.println(first);
        System.out.println(second);

        first.credit(10);
        first.transfer(second, 100);

        System.out.println(first);
        System.out.println(second);

        first.transfer(second, 15);

        System.out.println(first);
        System.out.println(second);

    }
}
