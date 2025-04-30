class TreeNode {
    private data: number;
    private left: TreeNode | null;
    private right: TreeNode | null;

    constructor(data: number) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    getData(): number {
        return this.data;
    }

    getLeft(): TreeNode | null {
        return this.left;
    }

    getRight(): TreeNode | null {
        return this.right;
    }

    setLeft(node: TreeNode): void {
        this.left = node;
    }

    setRight(node: TreeNode): void {
        this.right = node;
    }
}

function isBST(node: TreeNode | null, min: number = -Infinity, max: number = Infinity): boolean {
    if (!node) {
        return true;
    }
    const val: number = node.getData();

    if (val <= min || val >= max) {
        return false;
    }
    return isBST(node.getLeft(), min, val) && isBST(node.getRight(), val, max);
}

let root: TreeNode = new TreeNode(10);
let left: TreeNode = new TreeNode(5);
let right: TreeNode = new TreeNode(15);

root.setLeft(left);
root.setRight(right);

console.log(isBST(root));

export { };