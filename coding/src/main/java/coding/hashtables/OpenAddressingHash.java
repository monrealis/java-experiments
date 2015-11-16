package coding.hashtables;

public class OpenAddressingHash<K> {
    private K[] buckets;

    public OpenAddressingHash(int numberOfBuckets) {
        buckets = (K[]) new Object[numberOfBuckets];
    }

    public void add(K key) {
        int index = hash(key);
        while (buckets[index] != null)
            ++index;
        buckets[index] = key;
    }

    public boolean contains(K key) {
        int index = hash(key);
        while (buckets[index] != null)
            if (buckets[index].equals(key))
                return true;
            else
                ++index;
        return false;
    }

    private int hash(K key) {
        return key.hashCode() % buckets.length;
    }
}
