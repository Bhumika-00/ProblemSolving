import java.util.LinkedList;

public class HashMapImplementation<K, V> {
    private class Node {
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size;
    private LinkedList<Node>[] buckets;

    @SuppressWarnings("unchecked")
    public HashMapImplementation() {
        this.size = 0;
        this.buckets = new LinkedList[4];
        for (int i = 0; i < 4; i++) {
            this.buckets[i] = new LinkedList<>();
        }
    }

    private int bucketIndex(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    private int find(LinkedList<Node> bucket, K key) {
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i).key.equals(key)) {
                return i;
            }
        }
        return -1;
    }

    public void put(K key, V value) {
        int index = bucketIndex(key);
        LinkedList<Node> bucket = buckets[index];
        int findIndex = find(bucket, key);

        if (findIndex == -1) {
            bucket.add(new Node(key, value));
            size++;
        } else {
            bucket.get(findIndex).value = value;
        }
    }

    public static void main(String[] args) {
        HashMapImplementation<String, Integer> map = new HashMapImplementation<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("A", 10);

        System.out.println("Put operations completed.");
    }
}
