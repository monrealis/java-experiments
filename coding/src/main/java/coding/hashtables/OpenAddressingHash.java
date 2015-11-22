package coding.hashtables;

public class OpenAddressingHash<K> {
    private K[] buckets;
    private int elements;

    public OpenAddressingHash(int numberOfBuckets) {
        buckets = (K[]) new Object[numberOfBuckets];
    }

    public void add(K key) {
        if (elements == buckets.length)
            grow();
        if (contains(key))
            return;
        addNotNull(notNull(key));
    }

    private void grow() {
        OpenAddressingHash<K> other = new OpenAddressingHash<K>(buckets.length * 2);
        for (K el : buckets)
            other.add(el);
        this.buckets = other.buckets;
        this.elements = other.elements;
    }

    private void addNotNull(K key) {
        int index = index(key);
        while (buckets[index] != null)
            index = getNextBucketIndex(index);
        buckets[index] = key;
        elements++;
    }

    public boolean contains(K key) {
        return containsNotNull(notNull(key));
    }

    private boolean containsNotNull(K key) {
        for (int i = index(key); buckets[i] != null; i = getNextBucketIndex(i))
            if (buckets[i].equals(key))
                return true;
        return false;
    }

    public void remove(K key) {
        int index = index(key);
        while (buckets[index] != null)
            if (key.equals(buckets[index])) {
                elements--;
                int next = getNextBucketIndex(index);
                int initialIndex = index;
                buckets[index] = null;
                while (buckets[next] != null && next != initialIndex) {
                    if (index(buckets[next]) != next) {
                        buckets[index] = buckets[next];
                        buckets[next] = null;
                        index = next;
                    }
                    next = getNextBucketIndex(next);
                }
                break;
            } else
                index = getNextBucketIndex(index);
    }

    private K notNull(K key) {
        if (key == null)
            return (K) NULL;
        return key;
    }

    private int index(K key) {
        return key.hashCode() % buckets.length;
    }

    private int getNextBucketIndex(int index) {
        return (index + 1) % buckets.length;
    }

    private static final Object NULL = new Object() {
        @Override
        public int hashCode() {
            return 0;
        }

        @Override
        public boolean equals(Object obj) {
            return obj == this;
        }
    };


}
