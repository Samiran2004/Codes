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
    LinkedList.prototype.getHead = function () {
        return this.head;
    };
    LinkedList.prototype.setHead = function (node) {
        this.head = node;
    };
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
    //Display...
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
    //Add two numbers..
    LinkedList.prototype.addTwoNumbers = function (list1, list2) {
        var dummyNode = new ListNode(0);
        var carry = 0;
        var currNode = dummyNode;
        while (list1 || list2 || carry) {
            var sum = ((list1 === null || list1 === void 0 ? void 0 : list1.getData()) || 0) + ((list2 === null || list2 === void 0 ? void 0 : list2.getData()) || 0) + carry;
            carry = Math.floor(sum / 10);
            currNode.setNext(new ListNode(sum % 10));
            currNode = currNode.getNext();
            if (list1)
                list1 = list1.getNext();
            if (list2)
                list2 = list2.getNext();
        }
        return dummyNode.getNext();
    };
    return LinkedList;
}());
var list1 = new LinkedList();
list1.append(1);
list1.append(2);
list1.append(3);
console.log("List1: ");
list1.display();
var list2 = new LinkedList();
list2.append(5);
list2.append(4);
list2.append(3);
console.log("List2: ");
list2.display();
var result = new LinkedList();
result.setHead(result.addTwoNumbers(list1.getHead(), list2.getHead()));
console.log("Result: ");
result.display();
