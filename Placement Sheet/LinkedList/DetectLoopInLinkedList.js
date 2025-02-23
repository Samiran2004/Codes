"use strict";
var _a, _b, _c, _d, _e, _f, _g, _h, _j;
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
    NodeLL.prototype.setNext = function (node) {
        this.next = node;
    };
    NodeLL.prototype.getNext = function () {
        return this.next;
    };
    return NodeLL;
}());
var DetectLoopInLinkedList = /** @class */ (function () {
    function DetectLoopInLinkedList() {
        this.head = null;
        this.tail = null;
    }
    DetectLoopInLinkedList.prototype.insert = function (data) {
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
    DetectLoopInLinkedList.prototype.display = function () {
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
    DetectLoopInLinkedList.prototype.detectLoop = function () {
        var _a;
        if (this.head == null) {
            console.log("Loop is empty...");
            return;
        }
        var fastPtr = this.head;
        var slowPtr = this.head;
        while (slowPtr !== null && fastPtr !== null && fastPtr.getNext() !== null) {
            slowPtr = slowPtr.getNext();
            fastPtr = (_a = fastPtr.getNext()) === null || _a === void 0 ? void 0 : _a.getNext();
            if (slowPtr == fastPtr) {
                console.log("Loop detected...");
                return;
            }
        }
        console.log("No loop detected...");
    };
    return DetectLoopInLinkedList;
}());
var list = new DetectLoopInLinkedList();
list.insert(1);
list.insert(2);
list.insert(3);
list.insert(4);
list.insert(5);
list.insert(6);
list.insert(7);
list.display();
list.detectLoop();
// Creating a loop for testing
(_g = (_f = (_e = (_d = (_c = (_b = (_a = list.head) === null || _a === void 0 ? void 0 : _a.getNext()) === null || _b === void 0 ? void 0 : _b.getNext()) === null || _c === void 0 ? void 0 : _c.getNext()) === null || _d === void 0 ? void 0 : _d.getNext()) === null || _e === void 0 ? void 0 : _e.getNext()) === null || _f === void 0 ? void 0 : _f.getNext()) === null || _g === void 0 ? void 0 : _g.setNext(((_j = (_h = list.head) === null || _h === void 0 ? void 0 : _h.getNext()) === null || _j === void 0 ? void 0 : _j.getNext()) || null);
list.detectLoop();
