package Practice;

public class BST {
    public static class Node {
         int data;
         Node left;
         Node right;
         int height;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node rootNode;

    public BST(){}

    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty() {
        return rootNode == null;
    }

    public void display() {
        display(rootNode, "Root Node: ");
    }

    private void display(Node node, String details){
        if(node == null) {
            return;
        }

        System.out.println(details + node.data);

        display(node.left, "Left child of "+node.data+" is: ");
        display(node.right, "Right child of "+node.data+" is: ");
    }

    public void insert(int value) {
        rootNode = insert(value, rootNode);
    }

    private Node insert(int value, Node node) {
        if (node == null) {
            node = new Node(value);
            return node;
        }
        if (value < node.data) {
            node.left = insert(value, node.left);
        }
        if(value > node.data) {
            node.right = insert(value, node.right);
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    public boolean balanced() {
        return balanced(rootNode);
    }

    private boolean balanced(Node node) {
        if (node == null) {
            return true;
        }

        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    public void populate(int[] nums) {
        for (int num : nums) {
            this.insert(num);
        }
    }

    public void populateSorted(int[] nums) {
        populateSorted(nums, 0, nums.length);
    }

    private void populateSorted(int[] nums, int start, int end) {
        if(start >= end) {
            return;
        }

        int mid = (start + end) / 2;

        this.insert(nums[mid]);

        populateSorted(nums, start, mid);
        populateSorted(nums, mid + 1, end);
    }

    public static void main(String[] args) {
        BST tree = new BST();
        //int[] nums = {5, 2, 7, 1, 4, 6, 9, 8, 3, 10};
        // tree.populate(nums);
        //tree.display();
        //System.out.println("Tree is balanced: "+ tree.balanced());

        int[] sortedNums = {1, 2, 3, 4, 5, 6, 7, 8 ,9, 10};
        tree.populateSorted(sortedNums);
        tree.display();
        System.out.println("Tree is balanced: "+ tree.balanced());
    }
}