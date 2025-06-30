import java.util.ArrayList;

public class pr5 {
    public static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insertion(Node root, int values) {
        if (root == null) {
            root = new Node(values);
            return root;
        }
        if (root.data > values) {
            root.left = insertion(root.left, values);
        } else {
            root.right = insertion(root.right, values);
        }
        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static boolean searching(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        } else if (root.data > key) {
            return searching(root.left, key);
        } else {
            return searching(root.right, key);
        }
    }

    public static Node delete(Node root, int val) {
        if (root == null) {
            return null;
        }
        if (root.data > val) {
            root.left = delete(root.left, val);
        } else if (root.data < val) {
            root.right = delete(root.right, val);
        } else {
            System.out.println("Deleted node: " + root.data);
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                Node lcf = lefting(root.right);
                root.data = lcf.data;
                root.right = delete(root.right, lcf.data);
            }
        }
        return root;
    }

    public static void printInRange(Node root, int k1, int k2) {
        if (root == null)
            return;

        if (root.data > k1) {
            printInRange(root.left, k1, k2);
        }

        if (root.data >= k1 && root.data <= k2) {
            System.out.print(root.data + " ");
        }

        if (root.data < k2) {
            printInRange(root.right, k1, k2);
        }

    }
    public static void rootToLeafPath(Node root , ArrayList<Integer> list)
    {
        if(root==null)
        {
            return ;
        }
        list.add(root.data);
        if(root.left==null && root.right==null)
        {
            
        }
    }
    public static Node lefting(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        int values[] = { 5, 1, 3, 4, 2, 7 };
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insertion(root, values[i]);
        }
        inorder(root);
        System.out.println(searching(root, 3));
        root = delete(root, 5);
        inorder(root);
        System.out.println();
        printInRange(root, 2, 4);
    }
}
