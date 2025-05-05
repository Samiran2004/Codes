public class CheckBST {
    public static class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public int getData() {
            return data;
        }

        public TreeNode getLeft() {
            return left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }
    }

    public static boolean isBST(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }

        int val = node.getData();

        if (val <= min || val >= max) {
            return false;
        }

        return isBST(node.getLeft(), min, val) && isBST(node.getRight(), val, max);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(15);
        root.setLeft(left);
        root.setRight(right);
        System.out.println(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}
