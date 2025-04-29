import java.util.LinkedList;
import java.util.Queue;

public class LeftViewBinaryTree {
    public static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static Queue<Node> queue = new LinkedList<>();

    public static void printLeftView(Node root) {
        if (root == null) {
            return;
        }

        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                Node currNode = queue.poll();

                if (i == 0) {
                    System.out.print(currNode.data + " ");
                }

                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(50);
        root.right.right = new Node(60);

        printLeftView(root);
    }
}
