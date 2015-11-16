package coding.hashtables;

public class Hash<K> {
    private Entry<K>[] buckets;

    public Hash(int numberOfBuckets) {
        buckets = new Entry[numberOfBuckets];
        for (int i = 0; i < numberOfBuckets; ++i)
            buckets[i] = new NullEntry<>();
    }

    public boolean contains(K key) {
        Entry<K> entry = buckets[getBucketIndex(key)];
        while (entry != null)
            if (entry.is(key))
                return true;
            else
                entry = entry.getNext();
        return false;
    }

    public void add(K key) {
        if (contains(key))
            return;
        SimpleEntry<K> entry = new SimpleEntry<>(key);
        buckets[getBucketIndex(key)].getLast().setNext(entry);
    }

    public void remove(K key) {
        Entry<K> e = buckets[getBucketIndex(key)];
        while (e.getNext() != null)
            if (e.getNext().is(key))
                e.setNext(e.getNext().getNext());
            else
                e = e.getNext();
    }

    private int getBucketIndex(K key) {
        return key.hashCode() % buckets.length;
    }

    private static abstract class Entry<E> {
        private Entry<E> next;

        public Entry<E> getNext() {
            return next;
        }

        public void setNext(Entry<E> next) {
            this.next = next;
        }

        public abstract boolean is(E other);

        public Entry<E> getLast() {
            Entry<E> n = this;
            while (n.getNext() != null)
                n = n.getNext();
            return n;
        }
    }

    private static class NullEntry<E> extends Entry<E> {
        public boolean is(E other) {
            return false;
        }
    }

    private static class SimpleEntry<E> extends Entry<E> {
        private final E value;

        public SimpleEntry(E value) {
            this.value = value;
        }

        public boolean is(E other) {
            return value.equals(other);
        }
    }
}
