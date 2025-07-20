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

class LinkedlistStack {
    private top: NodeLL | null = null;
    private start: NodeLL | null = null;

    //Push...
    push(data: number): void {
        let newNode: NodeLL | null = new NodeLL(data);
        if (this.top == null) {
            this.start = newNode;
        }
        this.top?.setNext(newNode);
        this.top = newNode;
    }

    //Peek...
    peek(): void {
        if (this.top == null) {
            console.log("Stack is empty...");
            return;
        }
        const result: number = this.top.getData();
        console.log(`Top element: ${result}`);
    }

    //Pop...
    pop(): void {
        if (this.top == null) {
            console.log("Stack is empty...");
            return;
        }
        const value: number = this.top.getData();
        let currNode: NodeLL | null = this.start;
        while (currNode?.getNext() !== this.top) {
            currNode = currNode?.getNext()!;
        }
        currNode.setNext(this.top.getNext());
        this.top = currNode;
        console.log(`Poped element: ${value}`);
    }

    //Display...
    display(): void {
        if (this.top == null) {
            console.log("Stack is empty...");
            return;
        }
        let currNode: NodeLL | null = this.start;
        let result: number[] = [];
        while (currNode) {
            result.push(currNode.getData());
            currNode = currNode.getNext();
        }
        let length: number = result.length - 1;
        while (length >= 0) {
            console.log("|" + result[length] + "|");
            length--;
        }
    }
}

let Stack: LinkedlistStack = new LinkedlistStack();
Stack.push(1);
Stack.push(2);
Stack.push(3);
Stack.push(4);
Stack.push(5);
Stack.push(6);
Stack.peek();
Stack.pop();
Stack.peek();
Stack.display();

export { };