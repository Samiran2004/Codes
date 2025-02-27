"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var FNode = /** @class */ (function () {
    function FNode(data) {
        this.bottom = null;
        this.next = null;
        if (data) {
            this.data = data;
        }
    }
    return FNode;
}());
var FlatteningLinkList = /** @class */ (function () {
    function FlatteningLinkList() {
    }
    FlatteningLinkList.prototype.merge = function (a, b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        var result;
        if (a.data < b.data) {
            result = a;
            result.bottom = this.merge(a.bottom, b);
        }
        else {
            result = b;
            result.bottom = this.merge(a, b.bottom);
        }
        return result;
    };
    FlatteningLinkList.prototype.flatten = function (root) {
        if (root == null || root.next == null) {
            return root;
        }
        root.next = this.flatten(root.next);
        root = this.merge(root, root.next);
        return root;
    };
    FlatteningLinkList.prototype.printList = function (root) {
        var result = "";
        while (root !== null) {
            result += root.data + " --> ";
            root = root.bottom;
        }
        result += "NULL";
        console.log(result);
    };
    return FlatteningLinkList;
}());
var list = new FlatteningLinkList();
var root = new FNode(5);
root.bottom = new FNode(7);
root.bottom.bottom = new FNode(8);
root.bottom.bottom.bottom = new FNode(30);
root.next = new FNode(10);
root.next.bottom = new FNode(20);
root.next.next = new FNode(19);
root.next.next.bottom = new FNode(22);
root.next.next.bottom.bottom = new FNode(50);
root.next.next.next = new FNode(28);
root.next.next.next.bottom = new FNode(35);
root.next.next.next.bottom.bottom = new FNode(40);
root.next.next.next.bottom.bottom.bottom = new FNode(45);
root = list.flatten(root);
list.printList(root);
