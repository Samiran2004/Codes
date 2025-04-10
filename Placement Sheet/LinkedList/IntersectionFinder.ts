class NodeLL {
    data: number;
    next: NodeLL | null;

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

    setNext(node: NodeLL): void {
        this.next = node;
    }
}

class IntersectionFinder {
    private headA: NodeLL | null = null;
    private headB: NodeLL | null = null;

    insertToListA(data: number): void {
        this.headA = this.insertNode(this.headA, data);
    }

    insertToListB(data: number): void {
        this.headB = this.insertNode(this.headB, data);
    }

    insertNode(head: NodeLL | null, data: number): NodeLL {
        const newNode = new NodeLL(data);
        if (head === null) {
            return newNode;
        }
        let tempNode = head;
        while (tempNode.getNext() !== null) {
            tempNode = tempNode.getNext()!;
        }
        tempNode.setNext(newNode);
        return head;
    }

    display(head: NodeLL | null): void {
        if (head === null) {
            console.log("List is empty...");
            return;
        }
        let currNode: NodeLL | null = head;
        let result: string = "";
        while (currNode !== null) {
            result += currNode.data + " --> ";
            currNode = currNode.getNext();
        }
        result += "Null";
        console.log(result);
    }

    findIntersection(): void {
        let a: NodeLL | null = this.headA;
        let b: NodeLL | null = this.headB;

        while (a !== b) {
            a = (a === null) ? this.headB : a.getNext();
            b = (b === null) ? this.headA : b.getNext();
        }

        if (a !== null) {
            console.log("Intersection found at node with data: " + a.getData());
        } else {
            console.log("No intersection found...");
        }
    }

    setIntersection(common: NodeLL): void {
        let tempA: NodeLL | null | undefined = this.headA;
        while (tempA?.getNext() !== null) {
            tempA = tempA?.getNext();
        }
        tempA.setNext(common);

        let tempB: NodeLL | null | undefined = this.headB;
        while (tempB?.getNext() !== null) {
            tempB = tempB?.getNext();
        }
        tempB.setNext(common);
    }

    getHeadA(): NodeLL | null {
        return this.headA;
    }

    getHeadB(): NodeLL | null {
        return this.headB;
    }
}

const list = new IntersectionFinder();

// Creating List A: 1 -> 2 -> 3
list.insertToListA(1);
list.insertToListA(2);
list.insertToListA(3);

// Creating List B: 6
list.insertToListB(6);

// Common part: 8 -> 10
const common = new NodeLL(8);
common.setNext(new NodeLL(10));

// Connect both lists to common
list.setIntersection(common);

console.log("List A:");
list.display(list.getHeadA());

console.log("List B:");
list.display(list.getHeadB());

list.findIntersection();

export { };