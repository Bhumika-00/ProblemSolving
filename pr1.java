public class pr1 {
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
    public static Node insertion(Node root , int val)
    {
        if(root==null)
        {
            root = new Node(val);
            return root;

        }
        if(root.data>val)
        {
            root.left=insertion(root.left, val);
        }
        else
        {
            root.right = insertion(root.right, val);
        }
        return root;
    }
    public static Node delete(Node root , int val)
    {
        if(root.data<val)
        {
            root.right=delete(root.right, val);
        }
        else if(root.data>val)
        {
            root.left=delete(root.left, val);
        }
        else
        {
            if(root.left==null && root.right==null)
            {
                return null;
            }
            if(root.left==null)
            {
                return root.right;
            }
            else if(root.right==null)
            {
                return root.left;
            }
            else{
                Node ls=inOrderSuccessor(root.right);
                root.data=ls.data;
                root.right=delete(root.right, ls.data);
            }
        }
        return root;
    }
    public static Node inOrderSuccessor(Node root)
    {
        while (root.left!=null) {
            root=root.left;
        }
        return root;
    }
    public static void inOrder(Node root)
    {
        if(root==null)
        {
            return ;

        }
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }
    public static void main(String[] args) {
        int values[]={5,1,3,4,2,7};
        Node root = null;
        for(int i=0;i<values.length;i++)
        {
          root = insertion(root, values[i]);
        }
        inOrder(root);
    }
}
