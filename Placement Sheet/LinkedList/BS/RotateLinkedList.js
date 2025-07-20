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
var RotateLinkedList = /** @class */ (function () {
    function RotateLinkedList() {
        this.head = null;
        this.tail = null;
    }
    RotateLinkedList.prototype.insert = function (data) {
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
    RotateLinkedList.prototype.rotateList = function (k) {
        var _a;
        if (((_a = this.head) === null || _a === void 0 ? void 0 : _a.getNext()) == null) {
            console.log("List is empty...");
            return;
        }
        var length = 1;
        var tempNode = this.head;
        while (tempNode.getNext() !== null) {
            tempNode = tempNode === null || tempNode === void 0 ? void 0 : tempNode.getNext();
            length++;
        }
        tempNode.setNext(this.head);
        k = k % length;
        tempNode = this.head;
        for (var i = 0; i < length - k - 1; i++) {
            tempNode = tempNode === null || tempNode === void 0 ? void 0 : tempNode.getNext();
        }
        this.head = tempNode.getNext();
        tempNode.setNext(null);
        this.tail = tempNode;
    };
    RotateLinkedList.prototype.display = function () {
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
    return RotateLinkedList;
}());
var list = new RotateLinkedList();
list.insert(1);
list.insert(2);
list.insert(3);
list.insert(4);
list.insert(5);
list.insert(6);
list.display();
list.rotateList(3);
list.display();
