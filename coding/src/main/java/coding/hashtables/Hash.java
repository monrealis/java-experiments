package coding.hashtables;

public class Hash<K> {
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
        int index = getBucketIndex(key);
        Entry<K> first = buckets[index];
        Entry<K> entry = new Entry<>(key);
        if (first == null)
            buckets[index] = entry;
        else
            first.setNext(entry);
    }

    public void remove(K key) {
        int index = getBucketIndex(key);
        Entry<K> entry = buckets[index];
        Entry<K> previousEntry = null;
        while (entry != null) {
            if (entry.getValue().equals(key))
                if (previousEntry != null)
                    previousEntry.setNext(entry.getNext());
                else
                    buckets[index] = null;
            previousEntry = entry;
            entry = entry.getNext();
        }
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
