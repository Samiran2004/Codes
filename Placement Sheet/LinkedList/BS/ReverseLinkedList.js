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
var ReverseList = /** @class */ (function () {
    function ReverseList() {
        this.head = null;
        this.tail = null;
    }
    ReverseList.prototype.insert = function (data) {
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
    ReverseList.prototype.reverse = function () {
        var _a;
        if (((_a = this.head) === null || _a === void 0 ? void 0 : _a.getNext()) == null) {
            console.log("List is empty...");
            return;
        }
        var prevNode = null;
        var currNode = this.head;
        var nextNode = null;
        this.tail = this.head;
        while (currNode !== null) {
            nextNode = currNode.getNext();
            currNode.setNext(prevNode);
            prevNode = currNode;
            currNode = nextNode;
        }
        this.head = prevNode;
    };
    ReverseList.prototype.display = function () {
        var _a;
        if (((_a = this.head) === null || _a === void 0 ? void 0 : _a.getNext()) == null) {
            console.log("List is empty...");
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
    return ReverseList;
}());
var list1 = new ReverseList();
list1.insert(1);
list1.insert(2);
list1.insert(3);
list1.insert(4);
list1.insert(5);
list1.insert(6);
list1.display();
console.log("After reversal: ");
list1.reverse();
list1.display();
