class FNode {
    data: number;
    bottom: FNode | null = null;
    next: FNode | null = null;

    constructor(data?: number) {
        if(data) {
            this.data = data;
        }
    }
}

class FlatteningLinkList {
    merge(a: FNode | null, b: FNode | null): FNode {
        if (a == null) {
            return b!;
        }
        if (b == null) {
            return a;
        }
        let result: FNode;
        if (a.data < b.data) {
            result = a;
            result.bottom = this.merge(a.bottom, b);
        } else {
            result = b;
            result.bottom = this.merge(a, b.bottom);
        }
        return result;
    }

    flatten(root: FNode): FNode {
        if(root == null || root.next == null) {
            return root;
        }
        root.next = this.flatten(root.next);
        root = this.merge(root, root.next);
        return root;
    }

    printList(root: FNode | null): void {
        let result: string = "";
        while(root !== null) {
            result += root.data + " --> ";
            root = root.bottom;
        }
        result += "NULL";
        console.log(result);
    }
}

let list: FlatteningLinkList = new FlatteningLinkList();

let root: FNode = new FNode(5);
root.bottom = new FNode(7);
root.bottom.bottom = new FNode(8);
root.bottom.bottom.bottom = new FNode(30);

root.next = new FNode(10);
root.next.bottom = new FNode(20);

root.next.next = new FNode(19);
root.next.next.bottom = new FNode(22);
root.next.next.bottom.bottom = new FNode(50);

root.next.next.next = new FNode(28);
root.next.next.next.bottom = new FNode(35);
root.next.next.next.bottom.bottom = new FNode(40);
root.next.next.next.bottom.bottom.bottom = new FNode(45);

root = list.flatten(root);
list.printList(root);

export {};