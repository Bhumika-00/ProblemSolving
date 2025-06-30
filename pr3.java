import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class pr3 {

    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class Info {
        Node node;
        int hd;

        Info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static class BinaryTree {
        static int idx = -1;

        public static Node construction(int arr[]) {
            idx++;
            if (arr[idx] == -1) {
                return null;
            }

            Node root = new Node(arr[idx]);
            root.left = construction(arr);
            root.right = construction(arr);

            return root;
        }

        public static void preOrder(Node root) {
            if (root == null) {
                return;
            }
            preOrder(root.left);
            System.out.print(root.data + " ");
            preOrder(root.right);
        }

        public static void inorder(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            inorder(root.left);
            inorder(root.right);
        }

        public static void postOrder(Node root) {
            if (root == null) {
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

        public static void levelOrder(Node root) {
            Queue<Node> q1 = new LinkedList<>();
            q1.add(root);
            q1.add(null);

            while (!q1.isEmpty()) {
                Node curr = q1.remove();
                if (curr == null) {
                    System.out.println();
                    if (q1.isEmpty()) {
                        break;
                    } else {
                        q1.add(null);
                    }
                } else {
                    System.out.print(curr.data + " ");

                    if (curr.left != null) {
                        q1.add(curr.left);
                    }
                    if (curr.right != null) {
                        q1.add(curr.right);
                    }
                }
            }
        }

        public static int height(Node root) {
            if (root == null) {
                return 0;
            }

            int lh = height(root.left);
            int rh = height(root.right);
            return Math.max(lh, rh) + 1;
        }

        public static int countOfNodes(Node root) {
            if (root == null) {
                return 0;
            }
            int ln = countOfNodes(root.left);
            int rn = countOfNodes(root.right);

            return ln + rn + 1;
        }

        public static int sumOfNodes(Node root) {
            if (root == null) {
                return 0;
            }
            return sumOfNodes(root.left) + sumOfNodes(root.right) + root.data;
        }

        public static int diameterOfTree(Node root) {
            if (root == null)
                return 0;

            int leftDiameter = diameterOfTree(root.left);
            int rightDiameter = diameterOfTree(root.right);
            int throughRoot = height(root.left) + height(root.right) + 1;

            return Math.max(throughRoot, Math.max(leftDiameter, rightDiameter));
        }

        public static Node insert(int data) {
            return new Node(data);
        }

        public static boolean check(Node root, Node subroot) {
            if (root == null) {
                return false;
            }
            if (root.data == subroot.data) {
                if (isIdentical(root, subroot)) {
                    return true;
                }
            }

            return check(root.left, subroot) || check(root.right, subroot);

        }

        public static boolean isIdentical(Node root, Node subroot) {
            if (root == null && subroot == null) {
                return true;
            } else if (root == null || subroot == null) {
                return false;
            }
            if (root.data != subroot.data) {
                return false;
            }

            return isIdentical(root.left, subroot.left) && isIdentical(root.right, subroot.right);
        }

        static class info {
            Node data;
            int hd;

            info(Node data, int hd) {
                this.data = data;
                this.hd = hd;
            }
        }

        public static Node lca(Node root, Node n1, Node n2) {
            ArrayList<Node> l1 = new ArrayList<>();
            ArrayList<Node> l2 = new ArrayList<>();
            getPath(root, n1, l1);
            getPath(root, n2, l2);
            int idx = 0;
            for (int i = 0; i < l1.size(); i++) {
                if (l1.get(i) != l2.get(i)) {
                    idx = i - 1;
                    break;
                }
            }
            return l1.get(idx);
        }

        public static boolean getPath(Node root, Node n, ArrayList<Node> l) {
            if (root == null) {
                return false;
            }
            l.add(root);

            if (root == n) {
                return true;
            }
            boolean left = getPath(root.left, n, l);
            boolean right = getPath(root.right, n, l);

            if (left || right) {
                return true;
            }
            l.remove(l.size() - 1);
            return false;

        }

        public static Node find(Node root, int val) {
            if (root == null)
                return null;
            if (root.data == val)
                return root;
            Node left = find(root.left, val);
            if (left != null)
                return left;
            return find(root.right, val);
        }

        public static void TopView(Node root) {
            Queue<Info> q1 = new LinkedList<>();
            HashMap<Integer, Node> h1 = new HashMap<>();
            int min = 0, max = 0;
            q1.add(new Info(root, 0));
            q1.add(null);
            while (!q1.isEmpty()) {
                Info curr = q1.remove();
                if (curr == null) {
                    if (q1.isEmpty()) {
                        break;
                    } else {
                        q1.add(null);
                    }
                } else {
                    if (!h1.containsKey(curr.hd)) {
                        h1.put(curr.hd, curr.node);

                    }
                    if (curr.node.left != null) {
                        q1.add(new Info(curr.node.left, curr.hd - 1));
                        min = Math.min(min, curr.hd - 1);
                    }
                    if (curr.node.right != null) {
                        q1.add(new Info(curr.node.right, curr.hd + 1));
                        max = Math.max(max, curr.hd + 1);
                    }

                }
            }
            for (int i = min; i <= max; i++) {
                System.out.println(h1.get(i).data);
            }
        }

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = BinaryTree.construction(arr);
        System.out.println("Root Node: " + root.data);
        System.out.println("---------------------------------------");
        BinaryTree.preOrder(root);
        System.out.println();
        System.out.println("---------------------------------------");
        BinaryTree.inorder(root);
        System.out.println();
        System.out.println("---------------------------------------");
        BinaryTree.postOrder(root);
        System.out.println();
        System.out.println("---------------------------------------");
        BinaryTree.levelOrder(root);
        System.out.println();
        System.out.println("---------------------------------------");
        System.out.println(BinaryTree.height(root));
        System.out.println("---------------------------------------");
        System.out.println(BinaryTree.countOfNodes(root));
        System.out.println("---------------------------------------");
        System.out.println(BinaryTree.sumOfNodes(root));
        System.out.println("---------------------------------------");
        System.out.println(BinaryTree.diameterOfTree(root));
        System.out.println("---------------------------------------");
        Node subroot = BinaryTree.insert(2);
        subroot.left = BinaryTree.insert(4);
        subroot.right = BinaryTree.insert(5);
        System.out.println(BinaryTree.check(root, subroot));
        System.out.println("---------------------------------------");
        BinaryTree.TopView(root);
        System.out.println();
        System.out.println("---------------------------------------");
        // Find Node references for values 4 and 6
        Node n1 = find(root, 4);
        Node n2 = find(root, 6);

        // Find and print LCA
        Node lcaNode = lca(root, n1, n2);
        System.out.println("LCA of 4 and 6: " + (lcaNode != null ? lcaNode.data : "Not found"));
        System.out.println("---------------------------------------");
    }
}
