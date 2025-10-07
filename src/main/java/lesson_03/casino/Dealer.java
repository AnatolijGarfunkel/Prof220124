package lesson_03.casino;

import java.util.Random;

public class Dealer {

    private Random random = new Random();

    public Card getCard() {

        int length = Rank.values().length;

        int ordinal = random.nextInt(length);

        Rank rank = Rank.values()[ordinal];

        length = Suite.values().length;

        ordinal = random.nextInt(length);

        Suite suite = Suite.values()[ordinal];

        Card card = new Card(suite, rank);

        return card;
    }
}
