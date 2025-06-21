import java.util.ArrayList;

public class FinalPractise {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = left;
            this.right = right;
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

    public static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;

        } else if (root.data > key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }

    }

    public static Node delete(Node root, int key) {
        if (root.data > key) {
            root.left = delete(root.left, key);
        } else if (root.data < key) {
            root.right = delete(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                Node lt = leftOrderSuccessor(root.right);
                root.data = lt.data;
                root.right = delete(root.right, lt.data);
            }
        }
        return root;
    }

    public static Node leftOrderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void printInRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.data > k1) {
            printInRange(root.left, k1, k2);
        }
        if ((root.data >= k1) && (root.data <= k2)) {
            System.out.print(root.data + " ");
        }
        if (root.data < k2) {
            printInRange(root.right, k1, k2);
        }
    }
    
    public static void rootToLeafPath(Node root , ArrayList<Integer>list)
    {
        if(root==null)
        {
            return;
        }
        list.add(root.data);
        if(root.left == null && root.right==null)
        {
            System.out.println(list);
        }
        rootToLeafPath(root.left, list);
        rootToLeafPath(root.right, list);
        list.remove(list.size()-1);
    }
    public static boolean validateBST(Node root , Node min , Node max)
    {
     if(root==null)
     {
        return true;
     }
     if(min!=null && root.data<min)
     {
     return false;
     }
     else if(max!=null && root.data>max)
     {
        return false;
     }
     return validateBST(root.left, min, root)&& validateBST(root.right, root, max);
    }
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        int values[] = { 5, 1, 3, 4, 2, 7 };
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insertion(root, values[i]);
        }
        inOrder(root);
        System.out.println();
        System.out.println("----------------------------------");
        System.out.println(search(root, 0));
        System.out.println();
        System.out.println("----------------------------------");
        // root = delete(root, 1);
        inOrder(root);
        int k1 = 2, k2 = 5;
        System.out.println();
        System.out.println("----------------------------------");
        printInRange(root, k1, k2);
        System.out.println();
        System.out.println("----------------------------------");
        ArrayList<Integer> list = new ArrayList<>();
        rootToLeafPath(root,list );
    }
}