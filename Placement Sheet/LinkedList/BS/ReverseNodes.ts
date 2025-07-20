class NodeLL {
    private data: number;
    private next: NodeLL | null = null;

    constructor(data?: number) {
        if (data) {
            this.data = data;
        }
    }

    getData(): number {
        return this.data;
    }

    getNext(): NodeLL | null {
        return this.next;
    }

    setNext(node: NodeLL): void {
        this.next = node;
    }
}

class ReverseNodes {
    private head: NodeLL | null = null;
    private tail: NodeLL | null = null;

    insert(data: number): void {
        let newNode = new NodeLL(data);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        this.tail?.setNext(newNode);
        this.tail = newNode;
    }

    display(): void {
        if (this.head == null) {
            console.log("List is empty...");
            throw new Error("List is empty...");
        }
        let currNode: NodeLL | null = this.head;
        let result: string = "";
        while (currNode !== null) {
            result += currNode.getData() + " --> ";
            currNode = currNode.getNext();
        }
        result += "NULL";
        console.log(result);
    }

    reverseNode(head: NodeLL, k: number): NodeLL {
        if (head == null || k == 1) {
            return head;
        }

        let currNode: NodeLL | null = head;
        let count: number = 0;
        while (currNode !== null && count < k) {
            currNode = currNode.getNext();
            count++;
        }
        if (count < k) {
            return head;
        }

        let prevNode: NodeLL | null = null;
        let nextNode: NodeLL | null = null;
        count = 0;
        currNode = head;

        while (currNode !== null && count < k) {
            nextNode = currNode.getNext();
            currNode.setNext(prevNode as NodeLL);
            prevNode = currNode;
            currNode = nextNode;
            count++;
        }

        if (nextNode !== null) {
            head.setNext(this.reverseNode(nextNode, k));
        }

        return prevNode as NodeLL;
    }

    reverse(k: number): void {
        this.head = this.reverseNode(this.head as NodeLL, k);
    }
}

let list = new ReverseNodes();
list.insert(1);
list.insert(2);
list.insert(3);
list.insert(4);
list.insert(5);
list.insert(6);
list.display();
list.reverse(2);
list.display();

export { };