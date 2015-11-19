package coding.hashtables;

public class OpenAddressingHash<K> {
    private K[] buckets;

    public OpenAddressingHash(int numberOfBuckets) {
        buckets = (K[]) new Object[numberOfBuckets];
    }

    public void add(K key) {
        if (contains(key))
            return;
        addNotNull(notNull(key));
    }

    private void addNotNull(K key) {
        int index = index(key);
        while (buckets[index] != null)
            index = getNextBucketIndex(index);
        buckets[index] = key;
    }


    public boolean contains(K key) {
        return containsNotNull(notNull(key));
    }

    private boolean containsNotNull(K key) {
        int index = index(key);
        while (buckets[index] != null)
            if (buckets[index].equals(key))
                return true;
            else
                index = getNextBucketIndex(index);
        return false;
    }

    public void remove(K key) {
        int index = index(key);
        while (buckets[index] != null)
            if (key.equals(buckets[index])) {
                int next = getNextBucketIndex(index);
                buckets[index] = null;
                while (buckets[next] != null) {
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
