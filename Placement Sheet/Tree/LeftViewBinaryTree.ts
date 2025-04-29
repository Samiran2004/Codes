class TreeNode {
    private data: number;
    private left: TreeNode | null;
    private right: TreeNode | null;
    constructor(data: number) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    getData(): Number {
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

function printLeftViewTree(root: TreeNode | null): void | null {
    if (!root) {
        return null;
    }

    let queue: TreeNode[] = [];
    queue.push(root);

    while (queue.length > 0) {
        const level: number = queue.length;

        for (let i: number = 0; i < level; i++) {
            let currNode: TreeNode = queue.shift()!;

            if (i == 0) {
                console.log(currNode.getData() + " ");
            }

            if (currNode.getLeft()) {
                queue.push(currNode.getLeft()!);
            }

            if (currNode.getRight()) {
                queue.push(currNode.getRight()!);
            }
        }
    }
}

let root: TreeNode = new TreeNode(10);
root.setLeft(new TreeNode(20));
root.setRight(new TreeNode(30));
root.getLeft()!.setLeft(new TreeNode(40));
root.getLeft()!.setRight(new TreeNode(50));
root.getRight()!.setLeft(new TreeNode(50));
root.getRight()!.setRight(new TreeNode(60));

printLeftViewTree(root);

export { };