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


class FindMiddleOfLinkedList {
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

    findMiddle(): number {
        if(this.head == null) {
            console.log("List is empty...");
            return -1;
        }
        let slowPtr: NodeLL = this.head;
        let fastPtr: NodeLL = this.head;
        while(fastPtr !== null && fastPtr.getNext() !== null) {
            slowPtr = slowPtr.getNext();
            fastPtr = fastPtr.getNext()?.getNext();
        }
        return slowPtr.getData();
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
}


let list1 = new FindMiddleOfLinkedList();
list1.insert(1);
list1.insert(2);
list1.insert(3);
list1.insert(4);
list1.insert(5);
list1.insert(6);
list1.display();

let middle: number = list1.findMiddle();
console.log(`Middle node: ${middle}`);

export { };