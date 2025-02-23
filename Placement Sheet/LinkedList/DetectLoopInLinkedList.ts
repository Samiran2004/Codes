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

    setNext(node: NodeLL): void {
        this.next = node;
    }

    getNext(): NodeLL | null {
        return this.next;
    }
}

class DetectLoopInLinkedList {
    private head: NodeLL | null = null;
    private tail: NodeLL | null = null;

    insert(data: number): void {
        let newNode: NodeLL = new NodeLL(data);
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

    detectLoop(): void {
        if (this.head == null) {
            console.log("Loop is empty...");
            return;
        }
        let fastPtr: NodeLL | null = this.head;
        let slowPtr: NodeLL | null = this.head;
        while (slowPtr !== null && fastPtr !== null && fastPtr.getNext() !== null) {
            slowPtr = slowPtr.getNext();
            fastPtr = fastPtr.getNext()?.getNext()!;
            if (slowPtr == fastPtr) {
                console.log("Loop detected...");
                return;
            }
        }
        console.log("No loop detected...");
    }
}

let list: DetectLoopInLinkedList = new DetectLoopInLinkedList();
list.insert(1);
list.insert(2);
list.insert(3);
list.insert(4);
list.insert(5);
list.insert(6);
list.insert(7);
list.display();
list.detectLoop();

// Creating a loop for testing
list.head?.getNext()?.getNext()?.getNext()?.getNext()?.getNext()?.getNext()?.setNext(list.head?.getNext()?.getNext() || null!);
list.detectLoop();

export { };