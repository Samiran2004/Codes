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

class NthNodeFromLast {
    private head: NodeLL | null = null;
    private tail: NodeLL | null = null;

    insert(data: number): void {
        let newNode: NodeLL | null = new NodeLL(data);
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
            console.log("Lists is empty...");
            return;
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

    nthNodeFromLast(n: number): number | null {
        if (this.head == null) {
            console.log("List is empty...");
            return null;
        }
        let fastPtr: NodeLL | null = this.head;
        let slowPtr: NodeLL | null = this.head;
        for (let i: number = 0; i < n; i++) {
            if (fastPtr == null) {
                return null;
            }
            fastPtr = fastPtr.getNext();
        }
        while (fastPtr !== null) {
            fastPtr = fastPtr.getNext();
            slowPtr = slowPtr?.getNext()!;
        }
        return (slowPtr !== null) ? slowPtr.getData() : null;
    }
}

let list: NthNodeFromLast = new NthNodeFromLast();
list.insert(1);
list.insert(2);
list.insert(3);
list.insert(4);
list.insert(5);
list.insert(6);
list.insert(7);
list.display();
console.log(`Last n'th node: ${list.nthNodeFromLast(2)}`);

export { };