public class ArrayToTree {
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
     public static Node construct(int arr[],int start,int end)
     {
       if (start > end) return null; // base case
        int mid = (start+end)/2;
        Node root = new Node(arr[mid]);
        root.left=construct(arr,start,mid-1);
        root.right=construct(arr, mid+1, end);
        return root;
     }
    }
     public static void main(String[] args) {
        int arr[]={3,5,6,8,10,11,12};
        int start=0;
        int end = arr.length-1;
        BinaryTree b1 = new BinaryTree();
        Node root = b1.construct(arr, start, end);
        System.out.println(root.data);
    }
}
