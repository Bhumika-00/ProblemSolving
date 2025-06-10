import java.util.LinkedList;
import java.util.Queue;

public class PreOrder {
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
        static int idx=-1;
        public static Node buildTree(int nodes[])
        {
            idx++;
         if(nodes[idx]==-1)
         {
          return null;
         }
         Node newNode = new Node(nodes[idx]);
         newNode.left=buildTree(nodes);
         newNode.right=buildTree(nodes);

         return newNode;
        }

        public static void PreOrder(Node root)
        {
            if(root==null)
            {
                return;
            }
            System.out.print(root.data+" ");
            PreOrder(root.left);
            PreOrder(root.right);
        }
        public static void Inorder(Node root)
        {
            if(root==null)
            {
                return;
            }
            Inorder(root.left);
            System.out.print(root.data+" ");
            Inorder(root.right);
        }
        public static void PostOrder(Node root)
        {
            if(root==null)
            {
                return ;
            }
            PostOrder(root.left);
            System.out.print(root.data+" ");
            PostOrder(root.right);
        }
        public static int Height(Node root)
        {
            if(root==null)
            {
                return 0;
            }
            int lh = Height(root.left);
            int rh = Height(root.right);

            return (Math.max(lh, rh)+1);
        }
        public static int NodeCount(Node root)
        {
            if(root==null)
            {
                return 0;
            }
            int ln = NodeCount(root.left);
            int rh = NodeCount(root.right);

            return (ln+rh+1);
        }
        public static int SumOfNodes(Node root)
        {
            if(root==null)
            {
                return 0;
            }
            int lh=SumOfNodes(root.left);
            int rh=SumOfNodes(root.right);

            return (lh+rh+root.data);
        }
        public static void LevelOrderI(Node root)
        {
            if(root==null)
            {
                return ;
            }
            Queue<Node> q1=new LinkedList<>();
            q1.add(root);
            q1.add(null);
            while(!q1.isEmpty())
            {
             Node newNode = q1.remove();
             if(newNode==null)
             {
                System.out.println();
                if(q1.isEmpty())
                {
                    break;
                }
                else{
                    q1.add(null);
                }
             }
             else{
                System.out.print(newNode.data);
                if(newNode.left!=null)
                {
                    q1.add(newNode.left);
                }
                if(newNode.right!=null)
                {
                    q1.add(newNode.right);
                }
             }
            }
            
        }
        public static int diameter(Node root)
        {
            if(root==null)
            {
                return 0;
            }
            int rood=Height(root.left)+Height(root.right)+1;
            int rd=diameter(root.right);
            int ld=diameter(root.left);

            return Math.max(rood, Math.max(rd, ld));
        }
    }
    public static void main(String[] args) {
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree= new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(root.data);
        tree.PreOrder(root);
        System.out.println();
        tree.Inorder(root);
        System.out.println();
        tree.PostOrder(root);
        System.out.println();
        tree.LevelOrderI(root);
        System.out.println(tree.Height(root));
        System.out.println(tree.NodeCount(root));
        System.out.println(tree.SumOfNodes(root));
        System.out.println(tree.diameter(root));
    }
}
