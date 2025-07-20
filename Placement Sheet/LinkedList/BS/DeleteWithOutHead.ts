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

    setData(data: number): void {
        this.data = data;
    }
}

class LinkedList {
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

    //Get head...
    getHead(): NodeLL | null {
        return this.head;
    }

    //Find node...
    findNode(data: number): NodeLL | null {
        if (this.head == null) {
            console.log("List is empty...");
            return null;
        }
        let currNode: NodeLL | null = this.head;
        while (currNode !== null) {
            if (currNode.getData() == data) {
                return currNode;
            }
            currNode = currNode.getNext();
        }
        return null;
    }
}

function deleteNodeWithOutHead(node: NodeLL | null): void {
    if (node == null || node.getNext() == null) {
        console.log("Cannot delete the last node or a null node without head.");
        return;
    }
    let nextNode: NodeLL | null = node.getNext();
    node.setData(nextNode?.getData()!);
    node.setNext(nextNode?.getNext()!);
}

let list: LinkedList = new LinkedList();
list.insert(1);
list.insert(2);
list.insert(3);
list.insert(4);
list.insert(5);
list.insert(6);
console.log("List before remove...");
list.display();
console.log("List after remove...");
const nodeToDelete: NodeLL | null = list.findNode(4);
if (nodeToDelete !== null) {
    deleteNodeWithOutHead(nodeToDelete);
}
list.display();

export { };