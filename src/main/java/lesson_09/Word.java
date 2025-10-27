package lesson_09;

import java.util.List;
import java.util.Objects;

public class Word {

    private String word;

    private List<Integer> position;

    public Word(String word) {
        this.word = word;
    }

    public void setPosition(List<Integer> position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return Objects.equals(word, word1.word);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(word);
    }

    @Override
    public String toString() {
        String position = this.position.toString();
        return word + ":" + position;
    }
}
