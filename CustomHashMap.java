import java.util.LinkedList;

public class CustomHashMap<K, V> {
    private class Node {
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Node>[] buckets;
    private int size;

    @SuppressWarnings("unchecked")
    public CustomHashMap() {
        buckets = new LinkedList[4]; // initial capacity
        for (int i = 0; i < 4; i++) {
            buckets[i] = new LinkedList<>();
        }
        size = 0;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    private int findIndex(LinkedList<Node> bucket, K key) {
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i).key.equals(key)) return i;
        }
        return -1;
    }

    public void put(K key, V value) {
        int index = hash(key);
        LinkedList<Node> bucket = buckets[index];
        int foundIndex = findIndex(bucket, key);

        if (foundIndex == -1) {
            bucket.add(new Node(key, value));
            size++;
        } else {
            bucket.get(foundIndex).value = value;
        }

        if ((float) size / buckets.length > 2.0) {
            rehash();
        }
    }

    public V get(K key) {
        int index = hash(key);
        LinkedList<Node> bucket = buckets[index];
        int foundIndex = findIndex(bucket, key);
        if (foundIndex != -1) {
            return bucket.get(foundIndex).value;
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private void rehash() {
        LinkedList<Node>[] oldBuckets = buckets;
        buckets = new LinkedList[oldBuckets.length * 2];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }

        size = 0;
        for (LinkedList<Node> bucket : oldBuckets) {
            for (Node node : bucket) {
                put(node.key, node.value); // reinsert into new buckets
            }
        }
    }

    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("India", 100);
        map.put("USA", 200);
        map.put("China", 300);

        System.out.println(map.get("India")); // 100
        System.out.println(map.get("USA"));   // 200
        System.out.println(map.get("UK"));    // null
    }
}
