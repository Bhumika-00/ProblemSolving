public class pr2 {
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
            search(root.left, key);
        }
        else{
            search(root.right, key);
        }
        return false;
    }
    public static void main(String[] args) {
        int values[]={5,1,3,4,2,7};
        Node root = null;
        for(int i=0;i<values.length;i++)
        {
          root = insertion(root, values[i]);
        }
        System.out.println(search(root, 4));
    }
}
