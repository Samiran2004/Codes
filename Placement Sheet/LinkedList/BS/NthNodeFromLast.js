"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var NodeLL = /** @class */ (function () {
    function NodeLL(data) {
        this.next = null;
        if (data) {
            this.data = data;
        }
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
var NthNodeFromLast = /** @class */ (function () {
    function NthNodeFromLast() {
        this.head = null;
        this.tail = null;
    }
    NthNodeFromLast.prototype.insert = function (data) {
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
    NthNodeFromLast.prototype.display = function () {
        if (this.head == null) {
            console.log("Lists is empty...");
            return;
        }
        var currNode = this.head;
        var result = "";
        while (currNode !== null) {
            result += currNode.getData() + " --> ";
            currNode = currNode.getNext();
        }
        result += "NULL";
        console.log(result);
    };
    NthNodeFromLast.prototype.nthNodeFromLast = function (n) {
        if (this.head == null) {
            console.log("List is empty...");
            return null;
        }
        var fastPtr = this.head;
        var slowPtr = this.head;
        for (var i = 0; i < n; i++) {
            if (fastPtr == null) {
                return null;
            }
            fastPtr = fastPtr.getNext();
        }
        while (fastPtr !== null) {
            fastPtr = fastPtr.getNext();
            slowPtr = slowPtr === null || slowPtr === void 0 ? void 0 : slowPtr.getNext();
        }
        return (slowPtr !== null) ? slowPtr.getData() : null;
    };
    return NthNodeFromLast;
}());
var list = new NthNodeFromLast();
list.insert(1);
list.insert(2);
list.insert(3);
list.insert(4);
list.insert(5);
list.insert(6);
list.insert(7);
list.display();
console.log("Last n'th node: ".concat(list.nthNodeFromLast(2)));
