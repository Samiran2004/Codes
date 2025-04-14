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
    //Append data...
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
    //Check Palindrome...
    LinkedList.prototype.isPalindrome = function () {
        if (this.head == null || this.head.getNext() == null) {
            console.log("List is empty...");
            return false;
        }
        var values = [];
        var currNode = this.head;
        while (currNode !== null) {
            values.push(currNode.getData());
            currNode = currNode.getNext();
        }
        var startPtr = 0;
        var endPtr = values.length - 1;
        while (startPtr < endPtr) {
            if (values[startPtr] !== values[endPtr]) {
                return false;
            }
            startPtr++;
            endPtr--;
        }
        return true;
    };
    return LinkedList;
}());
var list = new LinkedList();
list.append(1);
list.append(2);
list.append(3);
list.append(3);
list.append(2);
list.append(1);
console.log("LinkedList: ");
list.display();
console.log("The List is palindrome: ".concat(list.isPalindrome()));
