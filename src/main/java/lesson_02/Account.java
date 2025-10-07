package lesson_02;

public class Account {

    private String id;

    private String name;

    private int balance = 0;

    public Account(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Account(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public int credit(int amount) {

        if (amount < 0) {
            System.out.println("credit amount не может быть отрицательным");
        }
        else {
            balance = balance + amount;
        }

        return balance;
    }

    public int transfer(Account account, int amount){

        if (amount < 0) {
            System.out.println("transfer amount не может быть отрицательным");
        }
        else if (amount > balance) {
            System.out.println("transfer amount не может быть больше баланса");
        }
        else {
            this.debit(amount);
            account.credit(amount);
        }

        return balance;
    }

    public int debit(int amount) {
        if (amount < 0) {
            System.out.println("debit amount не может быть отрицательным");
        }
        else if (amount > balance) {
            System.out.println("debit amount не может быть больше баланса");
        }
        else {
            balance -= amount;
        }

        return balance;
    }

    @Override
    public String toString() {
        return "id: " + id + "\nname: " + name + "\nbalance: " + balance;
    }
}









































