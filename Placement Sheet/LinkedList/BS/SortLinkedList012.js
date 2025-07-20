"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var NodeLL = /** @class */ (function () {
    function NodeLL(data) {
        this.data = data;
        this.next = null;
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
var SortLinkedList012 = /** @class */ (function () {
    function SortLinkedList012() {
        this.head = null;
    }
    //Insert...
    SortLinkedList012.prototype.insert = function (data) {
        var newNode = new NodeLL(data);
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
    SortLinkedList012.prototype.display = function () {
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
    //Sort012...
    SortLinkedList012.prototype.sort012 = function () {
        if (this.head == null) {
            console.log("List is empty...");
            return;
        }
        var zeroD = new NodeLL(0), oneD = new NodeLL(0), twoD = new NodeLL(0);
        var zero = zeroD, one = oneD, two = twoD;
        var currNode = this.head;
        while (currNode !== null) {
            if (currNode.getData() === 0) {
                zero.setNext(currNode);
                zero = zero.getNext();
            }
            else if (currNode.getData() === 1) {
                one.setNext(currNode);
                one = one.getNext();
            }
            else {
                two.setNext(currNode);
                two = two.getNext();
            }
            currNode = currNode.getNext();
        }
        zero.setNext(oneD.getNext() ? oneD.getNext() : twoD.getNext());
        one.setNext(twoD.getNext());
        two.setNext(null);
        this.head = zeroD.getNext();
    };
    return SortLinkedList012;
}());
var list = new SortLinkedList012();
list.insert(1);
list.insert(2);
list.insert(0);
list.insert(1);
list.insert(2);
list.insert(0);
console.log("Before sorting: ");
list.display();
console.log("After sorting: ");
list.sort012();
list.display();
