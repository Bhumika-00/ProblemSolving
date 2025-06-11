public class KthLevelOfATree {
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data)
        {
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }
    public static class BinaryTree{
        static Node root;
        public static Node cons(int data)
        {
            return new Node(data);
        }
        public static void Klevel(Node root , int k , int level){
            if(root==null)
            {
                return;
            }
            if(k==level)
            {
                System.out.print(root.data);
            }
             Klevel(root.left, k+1, level);
             Klevel(root.right, k+1, level);
        }
    }
    public static void main(String[] args) {
         BinaryTree tree = new BinaryTree();
        tree.root = BinaryTree.cons(1);  // root node with value 5

        // Add child nodes
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.Klevel(tree.root, 0, 2);
    }
}
