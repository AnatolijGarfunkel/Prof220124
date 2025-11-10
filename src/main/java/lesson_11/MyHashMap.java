package lesson_11;

public class MyHashMap implements MyMap {

    private int size = 0;

    private static final int INITIAL_CAPACITY = 4;

    private static final double LOAD_FACTOR = 0.75;

    private Pair[] source = new Pair[INITIAL_CAPACITY];

    private int capacity() {
        return source.length;
    }


    @Override
    public void put(String k, String v) {

    }

    @Override
    public String get(String k) {
        Pair pair = findPair(k);
        return pair != null ? pair.getValue() : null;
    }

    @Override
    public String remove(String k) {
        return "";
    }

    @Override
    public boolean contains(String k) {
        return findPair(k) != null;
    }

    private Pair findPair(String k) {
        int bucket = findBucket(k);
        Pair pair = source[bucket];
        while (pair != null) {
            if (pair.getKey().equals(k))
                return pair;
            pair = pair.getNext();
        }
        return null;
    }

    private int findBucket(String k) {
        int hashCode = k.hashCode();
        int bucket = hashCode % capacity();
        return Math.abs(bucket);
    }

    @Override
    public int size() {
        return size;
    }
}















































