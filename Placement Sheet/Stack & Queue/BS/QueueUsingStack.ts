class MyQueue<T> {
    private stack1: T[] = [];
    private stack2: T[] = [];

    enqueue(data: T): void {
        this.stack1.push(data);
    }

    dequeue(): T | undefined {
        if (this.isEmpty()) {
            return undefined;
        }
        if (this.stack2.length === 0) {
            while (this.stack1.length > 0) {
                this.stack2.push(this.stack1.pop()!);
            }
        }
        return this.stack2.pop();
    }

    peek(): T | undefined {
        if (this.stack2.length === 0) {
            while (this.stack1.length > 0) {
                this.stack2.push(this.stack1.pop()!);
            }
        }
        return this.stack2[this.stack1.length - 1];
    }

    isEmpty(): boolean {
        return this.stack1.length === 0 && this.stack2.length === 0;
    }
}

const queue = new MyQueue<number>();

queue.enqueue(10);
queue.enqueue(20);
queue.enqueue(30);

console.log(queue.dequeue());
console.log(queue.peek());
console.log(queue.dequeue());
console.log(queue.isEmpty());
console.log(queue.dequeue());
console.log(queue.isEmpty());

export { };