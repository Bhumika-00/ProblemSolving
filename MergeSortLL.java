public class MergeSortLL {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head;

    // Add node to the end
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
    }

    // Print the linked list
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public Node mid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node midNode = mid(head);
        Node leftHead = head;
        Node rightHead = midNode.next;
        midNode.next = null;
        Node newLeftHead = mergeSort(leftHead);
        Node newRightHead = mergeSort(rightHead);
      return  merge(newLeftHead, newRightHead);
    }

    public Node merge(Node newLeftHead, Node newRightHead) {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;
        while (newLeftHead != null && newRightHead != null) {
            if (newLeftHead.data < newRightHead.data) {
                temp.next = newLeftHead;
                newLeftHead = newLeftHead.next;
                temp = temp.next;
            } else {
                temp.next = newRightHead;
                newRightHead = newRightHead.next;
                temp = temp.next;
            }
        }
        while (newLeftHead != null) {
            temp.next = newLeftHead;
            newLeftHead = newLeftHead.next;
            temp = temp.next;
        }
        while (newRightHead != null) {
            temp.next = newRightHead;
            newRightHead = newRightHead.next;
            temp = temp.next;
        }
        return mergedLL.next;
    }

    public static void main(String[] args) {
        MergeSortLL list = new MergeSortLL();
        list.add(4);
        list.add(2);
        list.add(1);
        list.add(3);
        list.print();
        list.head = list.mergeSort(list.head);
        list.print();

        // You can now implement and call your merge sort method here
    }
}
