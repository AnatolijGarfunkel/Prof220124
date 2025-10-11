package lesson_06;

import java.util.Iterator;

public class StringIterator implements Iterator<Character> {

    private char [] chars;

    private int position = 0;

    public StringIterator(String string) {
        chars = string.toCharArray();
    }

    @Override
    public boolean hasNext() {
        return position < chars.length;
    }

    @Override
    public Character next() {
        return chars[position ++];
    }
}
