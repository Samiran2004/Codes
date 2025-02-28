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

class MergeSortedLinkedList {
    private head: NodeLL | null = null;
    private tail: NodeLL | null = null;
    getHead(): NodeLL | null {
        return this.head;
    }

    insert(data: number): void {
        let newNode: NodeLL | null = new NodeLL(data);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        this.tail?.setNext(newNode);
        this.tail = newNode;
    }

    display(root?: NodeLL | null): void {
        if (root) {
            if (root == null) {
                console.log("List is empty...");
                return;
            }
            let currNode: NodeLL | null = root;
            let result: string = "";
            while (currNode !== null) {
                result += currNode.getData() + " --> ";
                currNode = currNode.getNext();
            }
            result += "NULL";
            console.log(result);
        } else {
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

    mergeTwoSortedList(list1: NodeLL | null, list2: NodeLL | null): NodeLL | null {
        let dummy: NodeLL | null = new NodeLL(-1);
        let currNode: NodeLL | null | undefined = dummy;

        while (list1 !== null && list2 !== null) {
            if (list1.getData() <= list2.getData()) {
                currNode.setNext(list1);
                list1 = list1.getNext();
            } else {
                currNode?.setNext(list2);
                list2 = list2.getNext();
            }
            currNode = currNode?.getNext();
        }

        if (list1 !== null) {
            currNode?.setNext(list1);
        } else {
            currNode?.setNext(list2);
        }
        return dummy.getNext();
    }
}

let list1: MergeSortedLinkedList = new MergeSortedLinkedList();
list1.insert(1);
list1.insert(2);
list1.insert(3);
list1.insert(4);
list1.insert(5);
list1.insert(6);
console.log("List1: ");
list1.display();

let list2: MergeSortedLinkedList = new MergeSortedLinkedList();
list2.insert(7);
list2.insert(8);
list2.insert(9);
console.log("List2: ");
list2.display();

let result: MergeSortedLinkedList = new MergeSortedLinkedList();
let newHead: NodeLL | null = result.mergeTwoSortedList(list1.getHead(), list2.getHead());
result.display(newHead);

export { };