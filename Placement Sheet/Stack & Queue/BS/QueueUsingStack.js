"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var MyQueue = /** @class */ (function () {
    function MyQueue() {
        this.stack1 = [];
        this.stack2 = [];
    }
    MyQueue.prototype.enqueue = function (data) {
        this.stack1.push(data);
    };
    MyQueue.prototype.dequeue = function () {
        if (this.isEmpty()) {
            return undefined;
        }
        if (this.stack2.length === 0) {
            while (this.stack1.length > 0) {
                this.stack2.push(this.stack1.pop());
            }
        }
        return this.stack2.pop();
    };
    MyQueue.prototype.peek = function () {
        if (this.stack2.length === 0) {
            while (this.stack1.length > 0) {
                this.stack2.push(this.stack1.pop());
            }
        }
        return this.stack2[this.stack1.length - 1];
    };
    MyQueue.prototype.isEmpty = function () {
        return this.stack1.length === 0 && this.stack2.length === 0;
    };
    return MyQueue;
}());
var queue = new MyQueue();
queue.enqueue(10);
queue.enqueue(20);
queue.enqueue(30);
console.log(queue.dequeue());
console.log(queue.peek());
console.log(queue.dequeue());
console.log(queue.isEmpty());
console.log(queue.dequeue());
console.log(queue.isEmpty());
