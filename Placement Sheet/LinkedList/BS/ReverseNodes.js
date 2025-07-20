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
var ReverseNodes = /** @class */ (function () {
    function ReverseNodes() {
        this.head = null;
        this.tail = null;
    }
    ReverseNodes.prototype.insert = function (data) {
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
    ReverseNodes.prototype.display = function () {
        if (this.head == null) {
            console.log("List is empty...");
            throw new Error("List is empty...");
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
    ReverseNodes.prototype.reverseNode = function (head, k) {
        if (head == null || k == 1) {
            return head;
        }
        var currNode = head;
        var count = 0;
        while (currNode !== null && count < k) {
            currNode = currNode.getNext();
            count++;
        }
        if (count < k) {
            return head;
        }
        var prevNode = null;
        var nextNode = null;
        count = 0;
        currNode = head;
        while (currNode !== null && count < k) {
            nextNode = currNode.getNext();
            currNode.setNext(prevNode);
            prevNode = currNode;
            currNode = nextNode;
            count++;
        }
        if (nextNode !== null) {
            head.setNext(this.reverseNode(nextNode, k));
        }
        return prevNode;
    };
    ReverseNodes.prototype.reverse = function (k) {
        this.head = this.reverseNode(this.head, k);
    };
    return ReverseNodes;
}());
var list = new ReverseNodes();
list.insert(1);
list.insert(2);
list.insert(3);
list.insert(4);
list.insert(5);
list.insert(6);
list.display();
list.reverse(2);
list.display();
