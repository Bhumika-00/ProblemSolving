public class SizeOfLargestBST {
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
    public static class Info{
        boolean isBST;
        int size;
        int min;
        int max;

        Info(boolean isBST , int size , int min , int max)
        {
            this.isBST = isBST;
            this.size = size;
            this.min = min ;
            int max = max;
        }
    }
    public static int maxBst =0;
    public static Info LargestBST(Node root)
    {
        if(root==null)
        {
            return new Info(false, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        Info leftInfo = LargestBST(root.left);
        Info rightInfo = LargestBST(root.right);
        int size = leftInfo.size+rightInfo.size;
        int min = Math.min(root.data , Math.min(leftInfo.min , rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        if(root.data<=leftInfo.max || root.data>=rightInfo.min)
        {
            return new Info(false, size, min, max);
        }
        if(leftInfo.isBST && rightInfo.isBST)
        {
            maxBst = Math.max(maxBst,size);
           return new Info(true, size, min, max);
        }
        return new Info(false, size, min, max);
    }
    public static void main(String[] args) {
        Node root = new Node(50);
        root.left= new Node(30);
        root.right= new Node(60);
        root.left.left = new Node(5);
        root.left.right= new Node(20);
        root.right.right = new Node(70);
        root.right.left = new Node(45);
        root.right.right.right = new Node(80);
        root.right.right.left= new Node(65);
    }
}
