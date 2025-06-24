import java.util.ArrayList;

public class Heaping {

    public static class Heap {
        ArrayList<Integer> heap = new ArrayList<>();

        public void insert(int data) {
            heap.add(data);
            int child = heap.size() - 1;
            int parent = (child - 1) / 2;

            while (child > 0 && heap.get(child) < heap.get(parent)) {
                // Swap child and parent
                int temp = heap.get(child);
                heap.set(child, heap.get(parent));
                heap.set(parent, temp);

                // Update indices
                child = parent;
                parent = (child - 1) / 2;
            }
        }

        public int peek() {
            return heap.get(0);
        }

        public void printHeap() {
            System.out.println("Min Heap: " + heap);
        }

        public int remove() {
            int lastIdx = heap.size() - 1;
            int temp = heap.get(0);
            heap.set(0, heap.get(lastIdx));
            heap.set(lastIdx, temp);

            int removed = heap.remove(lastIdx);

            heapify(0);

            return removed;
        }

        public void heapify(int i) {
            int leftch = (2 * i + 1);
            int rightch = (2 * i + 2);
            int min = i;
            if (leftch < heap.size() && heap.get(min) > heap.get(leftch)) {
                min = leftch;
            }
            if (rightch < heap.size() && heap.get(min) > heap.get(rightch)) {
                min = rightch;
            }
            if (min != i) {
                int temp = heap.get(i);
                heap.set(i, heap.get(min));
                heap.set(min, temp);
                heapify(min);
            }
        }
    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.insert(50);
        h.insert(30);
        h.insert(40);
        h.insert(10);
        h.insert(20);
        h.printHeap(); // Expected: min-heap structure
        System.out.println(h.peek());
        System.out.println(h.remove());
        System.out.println(h.remove());
        System.out.println(h.remove());
    }
}
