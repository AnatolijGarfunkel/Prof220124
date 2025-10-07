package lesson_04.animals.reference;

import lesson_04.animals.Cat;

public class Passing {

    public static void main(String[] args) {

        Cat cat = new Cat("Trifon");

        System.out.println("cat before: " + cat);

        changeCat(cat);

        System.out.println("cat after: " + cat);

        changeCatForNew(cat);

        System.out.println("cat after Felix: " + cat);

    }

    public static void changeCat(Cat c) {
        c.setName("Puma");
    }

    private static void changeCatForNew(Cat c) {
        c = new Cat("Felix");
    }
}
