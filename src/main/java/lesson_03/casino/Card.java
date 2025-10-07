package lesson_03.casino;

public class Card {

    private Suite suite;

    private Rank rank;

    public Card(Suite suite, Rank rank) {
        this.suite = suite;
        this.rank = rank;
    }

    public int getValue() {
        int value = 0;
        value = rank.getValue();
        return value;
    }

    @Override
    public String toString() {
        return "Card{" +
                " suite: " + suite +
                ", rank: " + rank +
                "}";
    }
}
