package lesson_06;

import java.util.Iterator;

public class StringIterator implements Iterator<Character> {

    private String string;

    private int position = 0;

    public StringIterator(String string) {
        this.string = string;
    }

    @Override
    public boolean hasNext() {
        return position < string.length();
    }

    @Override
    public Character next() {
        return string.charAt(position ++);
    }
}
