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
var LinkedlistStack = /** @class */ (function () {
    function LinkedlistStack() {
        this.top = null;
        this.start = null;
    }
    //Push...
    LinkedlistStack.prototype.push = function (data) {
        var _a;
        var newNode = new NodeLL(data);
        if (this.top == null) {
            this.start = newNode;
        }
        (_a = this.top) === null || _a === void 0 ? void 0 : _a.setNext(newNode);
        this.top = newNode;
    };
    //Peek...
    LinkedlistStack.prototype.peek = function () {
        if (this.top == null) {
            console.log("Stack is empty...");
            return;
        }
        var result = this.top.getData();
        console.log("Top element: ".concat(result));
    };
    //Pop...
    LinkedlistStack.prototype.pop = function () {
        if (this.top == null) {
            console.log("Stack is empty...");
            return;
        }
        var value = this.top.getData();
        var currNode = this.start;
        while ((currNode === null || currNode === void 0 ? void 0 : currNode.getNext()) !== this.top) {
            currNode = currNode === null || currNode === void 0 ? void 0 : currNode.getNext();
        }
        currNode.setNext(this.top.getNext());
        this.top = currNode;
        console.log("Poped element: ".concat(value));
    };
    //Display...
    LinkedlistStack.prototype.display = function () {
        if (this.top == null) {
            console.log("Stack is empty...");
            return;
        }
        var currNode = this.start;
        var result = [];
        while (currNode) {
            result.push(currNode.getData());
            currNode = currNode.getNext();
        }
        var length = result.length - 1;
        while (length >= 0) {
            console.log("|" + result[length] + "|");
            length--;
        }
    };
    return LinkedlistStack;
}());
var Stack = new LinkedlistStack();
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
