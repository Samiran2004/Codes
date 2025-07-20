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
    NodeLL.prototype.setData = function (data) {
        this.data = data;
    };
    return NodeLL;
}());
var LinkedList = /** @class */ (function () {
    function LinkedList() {
        this.head = null;
    }
    //Insert...
    LinkedList.prototype.insert = function (data) {
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
    //Get head...
    LinkedList.prototype.getHead = function () {
        return this.head;
    };
    //Find node...
    LinkedList.prototype.findNode = function (data) {
        if (this.head == null) {
            console.log("List is empty...");
            return null;
        }
        var currNode = this.head;
        while (currNode !== null) {
            if (currNode.getData() == data) {
                return currNode;
            }
            currNode = currNode.getNext();
        }
        return null;
    };
    return LinkedList;
}());
function deleteNodeWithOutHead(node) {
    if (node == null || node.getNext() == null) {
        console.log("Cannot delete the last node or a null node without head.");
        return;
    }
    var nextNode = node.getNext();
    node.setData(nextNode === null || nextNode === void 0 ? void 0 : nextNode.getData());
    node.setNext(nextNode === null || nextNode === void 0 ? void 0 : nextNode.getNext());
}
var list = new LinkedList();
list.insert(1);
list.insert(2);
list.insert(3);
list.insert(4);
list.insert(5);
list.insert(6);
console.log("List before remove...");
list.display();
console.log("List after remove...");
var nodeToDelete = list.findNode(4);
if (nodeToDelete !== null) {
    deleteNodeWithOutHead(nodeToDelete);
}
list.display();
