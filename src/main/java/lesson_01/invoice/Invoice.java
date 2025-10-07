package lesson_01.invoice;

public class Invoice {

    private Item[] items;

    public Invoice(Item[] items) {
        this.items = items;
    }

    public Item[] getItems() {
        return items;
    }

    public double calculate() {
        double result = 0;

        if (items == null)
            return 0;

//        for (int i = 0; i < items.length; i ++) {
//            result = result + items[i].getUnitPrice() * items[i].getCount();
//        }

        for (int i = 0; i < items.length; i ++) {
            Item item = items[i];

            result += item.getCount() * item.getUnitPrice();
        }
        return result;
    }
}
