package lesson_03;

public class NewPizza {

    private PizzaSize size;

    private PizzaType type;

    private int salami = 0;

    private int mashrooms = 0;


    public NewPizza(PizzaSize size, PizzaType type, int salami, int mashrooms) {
        this.size = size;
        this.type = type;
        this.salami = salami;
        this.mashrooms = mashrooms;
    }

    public double calculatePrice() {
        double price = 0;

        switch (size) {
            case SMALL:
                price += 10;
                break;
            case MEDIUM:
                price += 12;
                break;
            case BIG:
                price += 14;
                break;
        }

        price += (salami + mashrooms) * 2;
        return price;
    }
}
