package lesson_03;

public class PizzaTester {

    public static void main(String[] args) {

        NewPizza n1 = new NewPizza(
                PizzaSize.SMALL,
                PizzaType.MARGARITA,
                2,
                1
        );

        double price = n1.calculatePrice();

        System.out.println("price of new: " + price);

    }
}
