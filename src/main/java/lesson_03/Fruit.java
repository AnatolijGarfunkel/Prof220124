package lesson_03;

public enum Fruit {

    APPLE(52, "red"),
    ORANGE(47, "orange"),
    BANANA(89, "yellow"),
    GRAPES(67, "green"),
    KIWI(61, "green");

    private int calories;
    private String color;

    Fruit(int calories, String color) {
        this.calories = calories;
        this.color = color;
    }

    public int getCalories() {
        return calories;
    }

    public String getColor() {
        return color;
    }
}
