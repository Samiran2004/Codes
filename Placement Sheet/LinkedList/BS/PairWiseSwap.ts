class ListNode {
    private data: number;
    private next: ListNode | null;

    constructor(data: number) {
        this.data = data;
        this.next = null;
    }

    getData(): number {
        return this.data;
    }

    getNext(): ListNode | null {
        return this.next;
    }

    setNext(node: ListNode): void {
        this.next = node;
    }
}

class LinkedList {
    private head: ListNode | null = null;

    //Insert...
    append(data: number): void {
        let newNode: ListNode = new ListNode(data);
        if (this.head == null) {
            this.head = newNode;
            return;
        }
        let currNode: ListNode | null = this.head;
        while (currNode.getNext() !== null) {
            currNode = currNode?.getNext()!;
        }
        currNode.setNext(newNode);
    }

    //Display the List...
    display(): void {
        if (this.head == null) {
            console.log("List is empty...");
            return;
        }
        let currNode: ListNode | null = this.head;
        let result: string = "";
        while (currNode !== null) {
            result += currNode.getData() + " --> ";
            currNode = currNode.getNext();
        }
        result += "Null";
        console.log(result);
    }

    //Swapping...
    pairSwap(): void {
        let dummyNode: ListNode = new ListNode(0);
        dummyNode.setNext(this.head!);
        let prevNode: ListNode | null = dummyNode;

        while (prevNode.getNext() && prevNode.getNext()?.getNext()) {
            let first = prevNode.getNext();
            let second = first?.getNext();

            first?.setNext(second?.getNext()!);
            second?.setNext(first!);
            prevNode.setNext(second!);
            prevNode = first;
        }

        this.head = dummyNode.getNext();
    }
}

let list: LinkedList = new LinkedList();
list.append(1);
list.append(2);
list.append(3);
list.append(4);
console.log("Before Swapping...");
list.display();
console.log("After Swapping...");
list.pairSwap();
list.display();

export { };