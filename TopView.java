import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopView {
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
    public static class BinaryTree{
        Node root;
        public static Node cons(int data)
        {
         return new Node(data);
        }
     public static class Info{
        Node node;
        int hd;
        Info(Node node , int hd)
        {
            this.node=node;
            this.hd=hd;
        }
     }
     public static void TopView(Node root)
     {
        Queue<Info> q1 = new LinkedList<>();
        HashMap<Integer,Node> h1 = new HashMap<>();
        int min=0,max=0;
        q1.add(new Info(root, 0));
        q1.add(null);
        while (!q1.isEmpty()) {
            Info curr = q1.remove();
            if(curr==null)
            {
                if(q1.isEmpty())
                {
                    break;
                }
                else{
                    q1.add(null);
                }
            }
            else{
                if(!h1.containsKey(curr.hd))
                {
                    h1.put(curr.hd, curr.node);

                }
                if(curr.node.left!=null)
                {
                    q1.add(new Info(curr.node.left, curr.hd-1));
                    min = Math.min(min, curr.hd-1);
                }
                if(curr.node.right!=null)
                {
                    q1.add(new Info(curr.node.right, curr.hd+1));
                    max = Math.max(max, curr.hd+1);
                }
                
            }
        }
        for(int i=min;i<max;i++)
        {
            System.out.println(h1.get(i).data);
        }
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
        tree.TopView(tree.root);
    }
}
