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

    setNext(node: NodeLL | null): void {
        this.next = node;
    }
}

class SortLinkedList012 {
    private head: NodeLL | null = null;

    //Insert...
    insert(data: number): void {
        let newNode: NodeLL | null = new NodeLL(data);
        if (this.head == null) {
            this.head = newNode;
            return;
        }
        let currNode: NodeLL | null = this.head;
        while (currNode.getNext() !== null) {
            currNode = currNode?.getNext()!;
        }
        currNode.setNext(newNode);
    }

    //Display...
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
        result += "Null";
        console.log(result);
    }

    //Sort012...
    sort012(): void {
        if (this.head == null) {
            console.log("List is empty...");
            return;
        }
        let zeroD: NodeLL | null = new NodeLL(0), oneD: NodeLL | null = new NodeLL(0), twoD: NodeLL | null = new NodeLL(0);
        let zero = zeroD, one = oneD, two = twoD;

        let currNode: NodeLL | null = this.head;
        while (currNode !== null) {
            if (currNode.getData() === 0) {
                zero.setNext(currNode);
                zero = zero.getNext()!;
            } else if (currNode.getData() === 1) {
                one.setNext(currNode);
                one = one.getNext()!;
            } else {
                two.setNext(currNode);
                two = two.getNext()!;
            }
            currNode = currNode.getNext();
        }
        zero.setNext(oneD.getNext() ? oneD.getNext() : twoD.getNext());
        one.setNext(twoD.getNext());
        two.setNext(null);
        this.head = zeroD.getNext();
    }
}

let list: SortLinkedList012 = new SortLinkedList012();
list.insert(1);
list.insert(2);
list.insert(0);
list.insert(1);
list.insert(2);
list.insert(0);
console.log("Before sorting: ");
list.display();
console.log("After sorting: ");
list.sort012();
list.display();

export { };