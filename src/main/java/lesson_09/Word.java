package lesson_09;

import java.util.List;
import java.util.Objects;

public class Word {

    private String word;

    private List<Integer> positiion;

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<Integer> getPositiion() {
        return positiion;
    }

    public void setPositiion(List<Integer> positiion) {
        this.positiion = positiion;
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
}
