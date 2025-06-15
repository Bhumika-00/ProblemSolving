public class BuildingBST {
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
    public static Node insertion(Node root , int value)
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
        for(int i=0;i<value.length;i++)
        {
           root = insertion(root, value[i]);
        }
        inorder(root);
        
    }
    
}
