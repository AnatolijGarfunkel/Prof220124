package lesson_01.invoice;

public class InvoiceTester {

    public static void main(String[] args) {


//        Item[] items = new Item[3];
//        items[0] = new Item("сверла", 2, 4.5);
//        items[1] = new Item("гвозди", 35, 0.05);
//        items[2] = new Item("кока-кола", 2, 0.6);

        Item[] items = {
                new Item("сверла", 2, 4.5),
                new Item("гвозди", 35, 0.05),
                new Item("кока-кола", 2, 0.6)
        };

        Invoice invoice = new Invoice(items);

        double price = 0;

        price = invoice.calculate();

        System.out.println("price: " + price);

    }
}
