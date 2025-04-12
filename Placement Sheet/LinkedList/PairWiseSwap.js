"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var ListNode = /** @class */ (function () {
    function ListNode(data) {
        this.data = data;
        this.next = null;
    }
    ListNode.prototype.getData = function () {
        return this.data;
    };
    ListNode.prototype.getNext = function () {
        return this.next;
    };
    ListNode.prototype.setNext = function (node) {
        this.next = node;
    };
    return ListNode;
}());
var LinkedList = /** @class */ (function () {
    function LinkedList() {
        this.head = null;
    }
    //Insert...
    LinkedList.prototype.append = function (data) {
        var newNode = new ListNode(data);
        if (this.head == null) {
            this.head = newNode;
            return;
        }
        var currNode = this.head;
        while (currNode.getNext() !== null) {
            currNode = currNode === null || currNode === void 0 ? void 0 : currNode.getNext();
        }
        currNode.setNext(newNode);
    };
    //Display the List...
    LinkedList.prototype.display = function () {
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
        result += "Null";
        console.log(result);
    };
    //Swapping...
    LinkedList.prototype.pairSwap = function () {
        var _a;
        var dummyNode = new ListNode(0);
        dummyNode.setNext(this.head);
        var prevNode = dummyNode;
        while (prevNode.getNext() && ((_a = prevNode.getNext()) === null || _a === void 0 ? void 0 : _a.getNext())) {
            var first = prevNode.getNext();
            var second = first === null || first === void 0 ? void 0 : first.getNext();
            first === null || first === void 0 ? void 0 : first.setNext(second === null || second === void 0 ? void 0 : second.getNext());
            second === null || second === void 0 ? void 0 : second.setNext(first);
            prevNode.setNext(second);
            prevNode = first;
        }
        this.head = dummyNode.getNext();
    };
    return LinkedList;
}());
var list = new LinkedList();
list.append(1);
list.append(2);
list.append(3);
list.append(4);
console.log("Before Swapping...");
list.display();
console.log("After Swapping...");
list.pairSwap();
list.display();
