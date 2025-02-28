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
var MergeSortedLinkedList = /** @class */ (function () {
    function MergeSortedLinkedList() {
        this.head = null;
        this.tail = null;
    }
    MergeSortedLinkedList.prototype.getHead = function () {
        return this.head;
    };
    MergeSortedLinkedList.prototype.insert = function (data) {
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
    MergeSortedLinkedList.prototype.display = function (root) {
        if (root) {
            if (root == null) {
                console.log("List is empty...");
                return;
            }
            var currNode = root;
            var result_1 = "";
            while (currNode !== null) {
                result_1 += currNode.getData() + " --> ";
                currNode = currNode.getNext();
            }
            result_1 += "NULL";
            console.log(result_1);
        }
        else {
            if (this.head == null) {
                console.log("List is empty...");
                return;
            }
            var currNode = this.head;
            var result_2 = "";
            while (currNode !== null) {
                result_2 += currNode.getData() + " --> ";
                currNode = currNode.getNext();
            }
            result_2 += "NULL";
            console.log(result_2);
        }
    };
    MergeSortedLinkedList.prototype.mergeTwoSortedList = function (list1, list2) {
        var dummy = new NodeLL(-1);
        var currNode = dummy;
        while (list1 !== null && list2 !== null) {
            if (list1.getData() <= list2.getData()) {
                currNode.setNext(list1);
                list1 = list1.getNext();
            }
            else {
                currNode === null || currNode === void 0 ? void 0 : currNode.setNext(list2);
                list2 = list2.getNext();
            }
            currNode = currNode === null || currNode === void 0 ? void 0 : currNode.getNext();
        }
        if (list1 !== null) {
            currNode === null || currNode === void 0 ? void 0 : currNode.setNext(list1);
        }
        else {
            currNode === null || currNode === void 0 ? void 0 : currNode.setNext(list2);
        }
        return dummy.getNext();
    };
    return MergeSortedLinkedList;
}());
var list1 = new MergeSortedLinkedList();
list1.insert(1);
list1.insert(2);
list1.insert(3);
list1.insert(4);
list1.insert(5);
list1.insert(6);
console.log("List1: ");
list1.display();
var list2 = new MergeSortedLinkedList();
list2.insert(7);
list2.insert(8);
list2.insert(9);
console.log("List2: ");
list2.display();
var result = new MergeSortedLinkedList();
var newHead = result.mergeTwoSortedList(list1.getHead(), list2.getHead());
result.display(newHead);
