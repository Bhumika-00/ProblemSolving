import java.util.ArrayDeque;
import java.util.ArrayList;

public class LowestCommonAncisstor {
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
        public static Node lca(Node root , int n1 ,int n2)
        {
            ArrayList<Node> path1 = new ArrayList<>();
            ArrayList<Node> path2 = new ArrayList<>();

            getPath(root , n1 , path1);
            getPath(root , n2 , path2);

            int i=0;
            for(i = 0; i < path1.size() && i < path2.size(); i++)

            {
                if(path1.get(i)!=path2.get(i))
                {
                    break;
                }
            }
          return path1.get(i-1);
        }
        public static boolean getPath(Node root , int n,  ArrayList<Node> path)
        {
            if(root==null)
            {
               return false;
            }
            path.add(root);
             if (root.data == n) {
                return true;
            }
            boolean leftFound = getPath(root.left, n, path);
            boolean rightFound = getPath(root.right, n, path);

            if(leftFound || rightFound)
            {
                return true;
            }
            path.remove(path.size()-1);
            return false;
        }
        public static int minDistance(Node root , int n1 ,int n2)
        {
            Node lca = lca(root, n1, n2);
            int leftDist = distance(lca , n1);
            int rightDist = distance(lca , n2);
            return leftDist+rightDist;
        }
        public static int distance(Node root , int n)
        {
            if(root==null)
            {
                return -1;
            }
            if(root.data==n)
            {
                return 0;
            }
            int ldis = distance(root.left, n);
            int rdis = distance(root.right, n);
            if(ldis==-1 && rdis==-1)
            {
                return -1;
            }
            else if(ldis==-1)
            {
                return rdis+1;
            }
            else
            {
                return ldis+1;
            }
        }
    }
    
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = BinaryTree.cons(1);  

       
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        
       Node result = tree.lca(tree.root, 4, 5);
System.out.println("LCA: " + (result != null ? result.data : "Not Found"));
if (result != null) {
    System.out.println(tree.minDistance(result, 4, 5));
} else {
    System.out.println("One or both nodes not found in the tree.");
}

        System.out.println(tree.minDistance(result, 4, 7));
    }
}
