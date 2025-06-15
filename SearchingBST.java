public class SearchingBST {
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
    public static Node insertion(Node root,int value)
    {
        if(root==null)
        {
            root = new Node(value);
            return root;
        }
        if(root.data>value)
        {
            root.left=insertion(root.left, value);
        }
        else{
            root.right = insertion(root.right, value);
        }
        return root;
    }
    public static boolean search(Node root , int key)
    {
        if(root==null)
        {
            return false;
        }
        if(root.data==key)
        {
            return true;
        }
        else if(root.data>key)
        {
           return search(root.left, key);
        }
        else
        {
           return search(root.right, key);
        }
        
    }
    public static void inorder(Node root)
    {
        if(root==null)
        {
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }
      public static void main(String[] args) {
       int value[]={5,1,3,4,2,7};
       Node root = null;
       int key=9;
       for(int i=0;i<value.length;i++)
       {
       root = insertion(root, value[i]);
       }
       inorder(root);
       System.out.println(search(root, key));
    }
}
