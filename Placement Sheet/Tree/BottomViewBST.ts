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

function bottomViewBST(root: TreeNode | null): number[] {
    if (!root) {
        return [];
    }
    const hdMap = new Map<number, number>();
    const queue: [TreeNode, number][] = [[root, 0]];

    while (queue.length > 0) {
        const [node, hd] = queue.shift();
        hdMap.set(hd, node.data);

        if (node.left) {
            queue.push([node.left, hd - 1]);
        }
        if (node.right) {
            queue.push([node.right, hd + 1]);
        }
    }

    const sortedKey = Array.from(hdMap.keys()).sort((a, b) => a - b);
    return sortedKey.map((key) => hdMap.get(key)!);
}

