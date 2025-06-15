import java.util.ArrayList;

public class RangeBST {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data)
        {
            this.data=data;
            this.left=null;
            this.right=null;
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
    public static void printInRange(Node root, int k1, int k2) {
    if (root == null) {
        return;
    }

    // Only go left if root's data is greater than k1
    if (root.data > k1) {
        printInRange(root.left, k1, k2);
    }

    // Print if root is within range
    if (root.data >= k1 && root.data <= k2) {
        System.out.println(root.data);
    }

    // Only go right if root's data is less than k2
    if (root.data < k2) {
        printInRange(root.right, k1, k2);
    }
}
   public static void pathToRoot(Node root , ArrayList<Integer>path)
   {
    if(root==null)
    {
        return ;
    }
    path.add(root.data);
    if(root.left== null && root.right==null)
    {
        System.out.println(path);
    }
    pathToRoot(root.left, path);
    pathToRoot(root.right, path);
    path.remove(path.size()-1);
   }
   public static void main(String[] args) {
    int value[] = { 1, 3, 4, 5, 6, 8, 10, 11, 14 };
        Node root = null;
        for (int i = 0; i < value.length; i++) {
            root = insertion(root, value[i]);
        }
        inorder(root);
        System.out.println("------------------------");
       // printInRange(root, 5, 14);
       ArrayList<Integer> path = new ArrayList<>();
        pathToRoot(root, path);
   }
}
