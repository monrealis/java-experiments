package coding.hashtables;

public class Hash<K, V> {
    private Entry<K>[] buckets;

    public Hash(int numberOfBuckets) {
        buckets = (Entry<K>[]) new Entry[numberOfBuckets];
    }

    public boolean contains(K key) {
        Entry<K> entry = buckets[getBucketIndex(key)];
        while (entry != null) {
            if (entry.getValue().equals(key))
                return true;
            entry = entry.getNext();
        }
        return false;
    }

    public void add(K key) {
        Entry<K> first = buckets[getBucketIndex(key)];
        Entry<K> entry = new Entry<>(key);
        if (first == null)
            buckets[getBucketIndex(key)] = entry;
        else
            first.setNext(entry);
    }

    private int getBucketIndex(K key) {
        return key.hashCode() % buckets.length;
    }

    private static class Entry<E> {
        private final E value;
        private Entry<E> next;

        private Entry(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        public Entry<E> getNext() {
            return next;
        }

        public void setNext(Entry<E> next) {
            this.next = next;
        }
    }
}
