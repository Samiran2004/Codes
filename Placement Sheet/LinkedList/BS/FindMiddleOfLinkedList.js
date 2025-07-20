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
var FindMiddleOfLinkedList = /** @class */ (function () {
    function FindMiddleOfLinkedList() {
        this.head = null;
        this.tail = null;
    }
    FindMiddleOfLinkedList.prototype.insert = function (data) {
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
    FindMiddleOfLinkedList.prototype.findMiddle = function () {
        var _a;
        if (this.head == null) {
            console.log("List is empty...");
            return -1;
        }
        var slowPtr = this.head;
        var fastPtr = this.head;
        while (fastPtr !== null && fastPtr.getNext() !== null) {
            slowPtr = slowPtr.getNext();
            fastPtr = (_a = fastPtr.getNext()) === null || _a === void 0 ? void 0 : _a.getNext();
        }
        return slowPtr.getData();
    };
    FindMiddleOfLinkedList.prototype.display = function () {
        if (this.head == null) {
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
    return FindMiddleOfLinkedList;
}());
var list1 = new FindMiddleOfLinkedList();
list1.insert(1);
list1.insert(2);
list1.insert(3);
list1.insert(4);
list1.insert(5);
list1.insert(6);
list1.display();
var middle = list1.findMiddle();
console.log("Middle node: ".concat(middle));
