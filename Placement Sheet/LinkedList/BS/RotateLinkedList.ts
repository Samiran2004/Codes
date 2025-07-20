class NodeLL {
    private data: number;
    private next: NodeLL | null = null;

    constructor(data?: number) {
        if(data) {
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

class RotateLinkedList {
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

    rotateList(k: number): void {
        if(this.head?.getNext() == null) {
            console.log("List is empty...");
            return;
        }
        let length: number = 1;
        let tempNode: NodeLL | null = this.head;
        while(tempNode.getNext() !== null) {
            tempNode = tempNode?.getNext()!;
            length++;
        }
        tempNode.setNext(this.head);
        k = k % length;
        tempNode = this.head;
        for(let i: number = 0; i<length-k-1; i++) {
            tempNode = tempNode?.getNext()!;
        }
        this.head = tempNode.getNext();
        tempNode.setNext(null);
        this.tail = tempNode;
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

let list = new RotateLinkedList();
list.insert(1);
list.insert(2);
list.insert(3);
list.insert(4);
list.insert(5);
list.insert(6);
list.display();
list.rotateList(3);
list.display();

export { };