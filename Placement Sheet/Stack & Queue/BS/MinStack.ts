class MinStack<T> {
    private stack: T[] = [];
    private minStack: T[] = [];

    //Push...
    push(data: T): void {
        this.stack.push(data);
        if (this.minStack.length == 0 || data <= this.getMin()) {
            this.minStack.push(data);
        }
    }

    //Pop...
    pop(): T | undefined {
        const poppedElm: T | undefined = this.stack.pop();
        if (poppedElm === this.getMin()) {
            this.minStack.pop();
        }
        return poppedElm;
    }

    //Peek...
    peek(): T | undefined {
        return this.stack[this.stack.length - 1];
    }

    getMin(): T {
        return this.minStack[this.minStack.length - 1];
    }
}

let minStack: MinStack<number> = new MinStack<number>();

minStack.push(5);
minStack.push(3);
minStack.push(7);
minStack.push(2);

console.log(`Min: ${minStack.getMin()}`);

minStack.pop();
console.log(`Min: ${minStack.getMin()}`);
console.log(`Top: ${minStack.peek()}`);

export { };