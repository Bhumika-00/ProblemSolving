public class Subroot {
    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static class BinaryTree {
        Node root;
        Node Subroot;
        public static Node construct(int data) {
            return new Node(data);
        }
        public static boolean isSubTree(Node root , Node Subroot)
        {
            if(root==null)
            {
                return false;
            }
            if(root.data==Subroot.data)
            {
                if(isIdentical(root,Subroot))
                {
                    return true;
                }
            }
            return isSubTree(root.left, Subroot)|| isSubTree(root.right, Subroot);
        }
        public static boolean isIdentical(Node root , Node Subroot)
        {
            if(root==null && Subroot==null)
            {
                return true;
            }
            if(root==null || Subroot==null)
            {
                return false;
            }
            if (root.data != Subroot.data) return false;
            return isIdentical(root.left, Subroot.left) && isIdentical(root.right, Subroot.right);
        }
    }

    public static void main(String[] args) {
        // Create tree root
        BinaryTree tree = new BinaryTree();
        tree.root = BinaryTree.construct(1);  // root node with value 5

        // Add child nodes
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        
        tree.Subroot = BinaryTree.construct(2); 
        tree.Subroot.left= new Node(4);
        tree.Subroot.right= new Node(5);
        System.out.println(tree.isSubTree(tree.root, tree.Subroot));
    }
}
