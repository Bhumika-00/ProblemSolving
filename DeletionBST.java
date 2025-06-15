public class DeletionBST {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insertion(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (root.data > value) {
            root.left = insertion(root.left, value);
        } else {
            root.right = insertion(root.right, value);
        }
        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    public static Node deletion(Node root, int key) {
        if (root == null) {
        return null; // important null check
    }
        if (root.data > key) {
            root.left= deletion(root.left, key);
        } else if (root.data < key) {
            root.right= deletion(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                Node successor = findInOrderSuccessor(root.right); // better name
                root.data = successor.data;
                root.right = deletion(root.right, successor.data);
            }

        }
        return root;

    }

    public static Node findInOrderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        int value[] = { 1, 3, 4, 5, 6, 8, 10, 11, 14 };
        Node root = null;
        for (int i = 0; i < value.length; i++) {
            root = insertion(root, value[i]);
        }
        inorder(root);
        System.out.println("------------------------");
        root = deletion(root, 1);
        inorder(root);
        System.out.println("------------------------");
        root = deletion(root, 10);
        inorder(root);
        System.out.println("------------------------");
        root = deletion(root, 5);
        inorder(root);
    }
}
