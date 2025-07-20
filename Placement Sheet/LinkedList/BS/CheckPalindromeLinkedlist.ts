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

    //Append data...
    append(data: number): void {
        let newNode: ListNode | null = new ListNode(data);
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

    //Check Palindrome...
    isPalindrome(): boolean {
        if (this.head == null || this.head.getNext() == null) {
            console.log("List is empty...");
            return false;
        }
        let values: number[] = [];
        let currNode: ListNode | null = this.head;
        while (currNode !== null) {
            values.push(currNode.getData());
            currNode = currNode.getNext();
        }
        let startPtr: number = 0;
        let endPtr: number = values.length - 1;

        while (startPtr < endPtr) {
            if (values[startPtr] !== values[endPtr]) {
                return false;
            }
            startPtr++;
            endPtr--;
        }
        return true;
    }
}

let list: LinkedList = new LinkedList();
list.append(1);
list.append(2);
list.append(3);
list.append(3);
list.append(2);
list.append(1);
console.log("LinkedList: ");
list.display();
console.log(`The List is palindrome: ${list.isPalindrome()}`);

export { };