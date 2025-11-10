package lesson_11;

public class MyHashMap implements MyMap{

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
        return "";
    }

    @Override
    public String remove(String k) {
        return "";
    }

    @Override
    public boolean contains(String k) {
        return findPair(k);
    }

    private boolean findPair(String k) {
        int bucket = findBucket(k);
        return false;
    }

    private int findBucket(String k) {
        int hashCode = k.hashCode();
        int bucket = hashCode % capacity();
        return bucket;
    }

    @Override
    public int size() {
        return size;
    }
}















































