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
var IntersectionFinder = /** @class */ (function () {
    function IntersectionFinder() {
        this.headA = null;
        this.headB = null;
    }
    IntersectionFinder.prototype.insertToListA = function (data) {
        this.headA = this.insertNode(this.headA, data);
    };
    IntersectionFinder.prototype.insertToListB = function (data) {
        this.headB = this.insertNode(this.headB, data);
    };
    IntersectionFinder.prototype.insertNode = function (head, data) {
        var newNode = new NodeLL(data);
        if (head === null) {
            return newNode;
        }
        var tempNode = head;
        while (tempNode.getNext() !== null) {
            tempNode = tempNode.getNext();
        }
        tempNode.setNext(newNode);
        return head;
    };
    IntersectionFinder.prototype.display = function (head) {
        if (head === null) {
            console.log("List is empty...");
            return;
        }
        var currNode = head;
        var result = "";
        while (currNode !== null) {
            result += currNode.data + " --> ";
            currNode = currNode.getNext();
        }
        result += "Null";
        console.log(result);
    };
    IntersectionFinder.prototype.findIntersection = function () {
        var a = this.headA;
        var b = this.headB;
        while (a !== b) {
            a = (a === null) ? this.headB : a.getNext();
            b = (b === null) ? this.headA : b.getNext();
        }
        if (a !== null) {
            console.log("Intersection found at node with data: " + a.getData());
        }
        else {
            console.log("No intersection found...");
        }
    };
    IntersectionFinder.prototype.setIntersection = function (common) {
        var tempA = this.headA;
        while ((tempA === null || tempA === void 0 ? void 0 : tempA.getNext()) !== null) {
            tempA = tempA === null || tempA === void 0 ? void 0 : tempA.getNext();
        }
        tempA.setNext(common);
        var tempB = this.headB;
        while ((tempB === null || tempB === void 0 ? void 0 : tempB.getNext()) !== null) {
            tempB = tempB === null || tempB === void 0 ? void 0 : tempB.getNext();
        }
        tempB.setNext(common);
    };
    IntersectionFinder.prototype.getHeadA = function () {
        return this.headA;
    };
    IntersectionFinder.prototype.getHeadB = function () {
        return this.headB;
    };
    return IntersectionFinder;
}());
var list = new IntersectionFinder();
// Creating List A: 1 -> 2 -> 3
list.insertToListA(1);
list.insertToListA(2);
list.insertToListA(3);
// Creating List B: 6
list.insertToListB(6);
// Common part: 8 -> 10
var common = new NodeLL(8);
common.setNext(new NodeLL(10));
// Connect both lists to common
list.setIntersection(common);
console.log("List A:");
list.display(list.getHeadA());
console.log("List B:");
list.display(list.getHeadB());
list.findIntersection();
