"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var NodeLL = /** @class */ (function () {
    function NodeLL(data) {
        this.data = data;
        this.next = null;
    }
    NodeLL.prototype.getData = function () {
        return this.data;
    };
    NodeLL.prototype.getNext = function () {
        return this.next;
    };
    NodeLL.prototype.setNext = function (node) {
        this.next = node;
    };
    return NodeLL;
}());
var LinkedListQueue = /** @class */ (function () {
    function LinkedListQueue() {
        this.head = null;
        this.tail = null;
    }
    LinkedListQueue.prototype.enqueue = function (data) {
        var _a;
        var newNode = new NodeLL(data);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        (_a = this.tail) === null || _a === void 0 ? void 0 : _a.setNext(newNode);
        this.tail = newNode;
    };
    LinkedListQueue.prototype.dequeue = function () {
        if (this.head == null) {
            console.log("Queue is empty...");
            return null;
        }
        else {
            var value = this.head.getData();
            this.head = this.head.getNext();
            return value;
        }
    };
    LinkedListQueue.prototype.display = function () {
        if (this.head == null) {
            console.log("List is empty...");
            return;
        }
        var currNode = this.head;
        var result = [];
        while (currNode) {
            result.push(currNode.getData());
            currNode = currNode.getNext();
        }
        console.log(result.join(" --> ") + " -> Null");
    };
    return LinkedListQueue;
}());
var queue = new LinkedListQueue();
queue.enqueue(1);
queue.enqueue(2);
queue.enqueue(3);
queue.enqueue(4);
queue.enqueue(5);
queue.enqueue(6);
queue.display();
queue.dequeue();
queue.display();
