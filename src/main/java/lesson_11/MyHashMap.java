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
        Pair pair = findPair(k);
        if (pair != null) {
            pair.setValue(v);
            return;
        }
        if (size() > LOAD_FACTOR * capacity()) {
            resize(k, v);
        }
        if (pair == null) {
            int bucket = findBucket(k);
            if (source[bucket] == null) {
                pair = new Pair(k, v, null);
                source[bucket] = pair;
            }
            else {
                pair = source[bucket];
                while (pair.getNext() != null)
                    pair = pair.getNext();
                pair.setNext(new Pair(k, v, null));
            }
            size ++;
        }
    }

    private void resize(String k, String v) {
        Pair[] newSource = new Pair[capacity() * 2];
        size = 0;

        for (Pair data : source) {
            if (data != null) {
                while (data != null) {
                    rePut(newSource, data.getKey(), data.getValue());
                    data = data.getNext();
                }
            }
        }
        source = newSource;
    }

    private void rePut(Pair[] newSource, String key, String value) {
        Pair pair = reFindPair(newSource, key);
        if (pair != null) {
            pair.setValue(value);
            return;
        }
        if (pair == null) {
            int bucket = Math.abs(key.hashCode() % (capacity() * 2));
            if (newSource[bucket] == null) {
                pair = new Pair(key, value, null);
                newSource[bucket] = pair;
            } else {
                pair = newSource[bucket];
                while (pair.getNext() != null)
                    pair = pair.getNext();
                pair.setNext(new Pair(key, value, null));
            }
            size++;
        }
    }

    private Pair reFindPair(Pair[] newSource, String key) {
        int bucket = Math.abs(key.hashCode() % (capacity() * 2));
        Pair pair = newSource[bucket];
        while (pair != null) {
            if (pair.getKey().equals(key))
                return pair;
            pair = pair.getNext();
        }
        return null;
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

    @Override
    public String toString() {
        String result = "\n";
        for (int i = 0; i < source.length; i ++) {
            if (source[i] != null) {
                Pair pair = source[i];
                while (pair != null) {
                    result += "[" + i + "]";
                    if (pair.getNext() == null)
                        result += "[" + pair.getKey() + " : " + pair.getValue() + "]\n";
                    else
                        result += "[" + pair.getKey() + " : " + pair.getValue() + "], ";
                    pair = pair.getNext();
                }
            }
        }
        return result;
    }
}















































