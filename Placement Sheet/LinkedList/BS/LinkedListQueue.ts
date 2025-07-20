class NodeLL {
    private data: number;
    private next: NodeLL | null;
    constructor(data: number) {
        this.data = data;
        this.next = null;
    }

    getData(): number {
        return this.data;
    }

    getNext(): NodeLL | null {
        return this.next;
    }

    setNext(node: NodeLL | null) {
        this.next = node;
    }
}

class LinkedListQueue {
    private head: NodeLL | null = null;
    private tail: NodeLL | null = null;

    enqueue(data: number): void {
        let newNode: NodeLL = new NodeLL(data);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        this.tail?.setNext(newNode);
        this.tail = newNode;
    }

    dequeue(): number | null {
        if (this.head == null) {
            console.log("Queue is empty...");
            return null;
        } else {
            const value = this.head.getData();
            this.head = this.head.getNext();
            return value;
        }
    }

    display(): void {
        if (this.head == null) {
            console.log("List is empty...");
            return;
        }
        let currNode: NodeLL | null = this.head;
        let result: number[] = [];
        while (currNode) {
            result.push(currNode.getData());
            currNode = currNode.getNext();
        }
        console.log(result.join(" --> ") + " -> Null");
    }
}

let queue: LinkedListQueue = new LinkedListQueue();
queue.enqueue(1);
queue.enqueue(2);
queue.enqueue(3);
queue.enqueue(4);
queue.enqueue(5);
queue.enqueue(6);
queue.display();
queue.dequeue();
queue.display();

export { };