public class pr4 {
    public static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class BinarySearchTree {
        public static Node construction(Node root, int value) {
            if (root == null) {
                return new Node(value);
            }
            if (value < root.data) {
                root.left = construction(root.left, value);
            } else {
                root.right = construction(root.right, value);
            }
            return root;
        }

        // Optional: Inorder traversal to verify tree structure
        public static void inorder(Node root) {
            if (root == null) return;
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        int[] val = {5, 1, 3, 4, 2, 7};
        Node root = null;

        // Build BST
        for (int x : val) {
            root = BinarySearchTree.construction(root, x);
        }

        // Print inorder to verify BST
        System.out.print("Inorder Traversal: ");
        BinarySearchTree.inorder(root);  // Output should be sorted
    }
}
