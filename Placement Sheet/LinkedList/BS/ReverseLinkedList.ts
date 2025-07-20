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

class ReverseList {
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

    reverse(): void {
        if (this.head?.getNext() == null) {
            console.log("List is empty...");
            return;
        }
        let prevNode: NodeLL | null = null;
        let currNode: NodeLL | null = this.head;
        let nextNode: NodeLL | null = null;
        this.tail = this.head;
        while (currNode !== null) {
            nextNode = currNode.getNext();
            currNode.setNext(prevNode!);
            prevNode = currNode;
            currNode = nextNode;
        }
        this.head = prevNode;
    }

    display(): void {
        if (this.head?.getNext() == null) {
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
}

let list1 = new ReverseList();
list1.insert(1);
list1.insert(2);
list1.insert(3);
list1.insert(4);
list1.insert(5);
list1.insert(6);
list1.display();
console.log("After reversal: ");
list1.reverse();
list1.display();

export { };