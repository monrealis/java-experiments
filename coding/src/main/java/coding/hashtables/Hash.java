package coding.hashtables;

public class Hash<K> {
    private Entry<K>[] buckets;

    public Hash(int numberOfBuckets) {
        buckets = (SimpleEntry<K>[]) new SimpleEntry[numberOfBuckets];
    }

    public boolean contains(K key) {
        Entry<K> entry = buckets[getBucketIndex(key)];
        while (entry != null) {
            if (entry.isValueEqualTo(key))
                return true;
            entry = entry.getNext();
        }
        return false;
    }

    public void add(K key) {
        int index = getBucketIndex(key);
        Entry<K> first = buckets[index];
        SimpleEntry<K> entry = new SimpleEntry<>(key);
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
            if (entry.isValueEqualTo(key))
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

    private static abstract class Entry<E> {
        private SimpleEntry<E> next;

        public SimpleEntry<E> getNext() {
            return next;
        }

        public void setNext(SimpleEntry<E> next) {
            this.next = next;
        }

        public abstract boolean isValueEqualTo(E other);
    }


    private static class NullEntry<E> extends Entry<E> {
        public boolean isValueEqualTo(E other) {
            return false;
        }
    }

    private static class SimpleEntry<E> extends Entry<E> {
        private final E value;

        public SimpleEntry(E value) {
            this.value = value;
        }

        public boolean isValueEqualTo(E other) {
            return value.equals(other);
        }
    }
}
