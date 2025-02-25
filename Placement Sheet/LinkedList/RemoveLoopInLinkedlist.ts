class NodeLL {
    private data: number;
    private next: NodeLL | null = null;
    constructor(data?: number) {
        if (data) {
            this.data = data;
        }
    }
    getData(): number | undefined {
        return this.data;
    }

    getNext(): NodeLL | null {
        return this.next;
    }

    setNext(node: NodeLL | null): void {
        this.next = node;
    }
}

class RemoveLoopInLinkedlist {
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

    removeLoop(): void {
        if (this.head == null) {
            console.log("List is empty...");
            return;
        }
        let fastPtr: NodeLL | null | undefined = this.head;
        let slowPtr: NodeLL | null | undefined = this.head;
        let isLoopExist: boolean = false;
        while (slowPtr !== null && fastPtr !== null && fastPtr.getNext() !== null) {
            slowPtr = slowPtr.getNext();
            fastPtr = fastPtr.getNext()?.getNext()!;
            if (slowPtr == fastPtr) {
                console.log("Loop exist...");
                isLoopExist = true;
                break;
            }
        }
        if (!isLoopExist) {
            console.log("No Loop exist...");
            return;
        }
        // Find the start of the loop...
        slowPtr = this.head;
        let prevNode: NodeLL | null = null;
        while (slowPtr !== fastPtr) {
            prevNode = fastPtr;
            slowPtr = slowPtr?.getNext();
            fastPtr = fastPtr?.getNext();
        }
        prevNode?.setNext(null);
        console.log("Loop removed....");
    }
}

let list = new RemoveLoopInLinkedlist();
list.insert(1);
list.insert(2);
list.insert(3);
list.insert(4);
list.insert(5);
list.insert(6);
list.insert(7);
list.display();
list.head?.getNext()?.getNext()?.getNext()?.getNext()?.getNext()?.getNext()?.setNext(list.head?.getNext()?.getNext() || null!);
list.removeLoop();
list.display();

export { };