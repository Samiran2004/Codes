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

    setNext(node: ListNode | null) {
        this.next = node;
    }
}

class LinkedList {
    private head: ListNode | null = null;

    getHead(): ListNode | null {
        return this.head;
    }

    setHead(node: ListNode | null): void {
        this.head = node;
    }


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

    //Display...
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

    //Add two numbers..
    addTwoNumbers(list1: ListNode | null, list2: ListNode | null): ListNode | null {
        const dummyNode: ListNode = new ListNode(0);
        let carry: number = 0;
        let currNode: ListNode = dummyNode;

        while (list1 || list2 || carry) {
            const sum: number = (list1?.getData() || 0) + (list2?.getData() || 0) + carry;
            carry = Math.floor(sum / 10);
            currNode.setNext(new ListNode(sum % 10));
            currNode = currNode.getNext()!;

            if (list1) list1 = list1.getNext();
            if (list2) list2 = list2.getNext();
        }

        return dummyNode.getNext();
    }
}

let list1: LinkedList = new LinkedList();
list1.append(1);
list1.append(2);
list1.append(3);
console.log("List1: ");
list1.display();

let list2: LinkedList = new LinkedList();
list2.append(5);
list2.append(4);
list2.append(3);
console.log("List2: ");
list2.display()

let result: LinkedList = new LinkedList();
result.setHead(result.addTwoNumbers(list1.getHead(), list2.getHead()));
console.log("Result: ");
result.display()

export { };