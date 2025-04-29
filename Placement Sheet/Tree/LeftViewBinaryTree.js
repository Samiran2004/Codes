"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var TreeNode = /** @class */ (function () {
    function TreeNode(data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    TreeNode.prototype.getData = function () {
        return this.data;
    };
    TreeNode.prototype.getLeft = function () {
        return this.left;
    };
    TreeNode.prototype.getRight = function () {
        return this.right;
    };
    TreeNode.prototype.setLeft = function (node) {
        this.left = node;
    };
    TreeNode.prototype.setRight = function (node) {
        this.right = node;
    };
    return TreeNode;
}());
function printLeftViewTree(root) {
    if (!root) {
        return null;
    }
    var queue = [];
    queue.push(root);
    while (queue.length > 0) {
        var level = queue.length;
        for (var i = 0; i < level; i++) {
            var currNode = queue.shift();
            if (i == 0) {
                console.log(currNode.getData() + " ");
            }
            if (currNode.getLeft()) {
                queue.push(currNode.getLeft());
            }
            if (currNode.getRight()) {
                queue.push(currNode.getRight());
            }
        }
    }
}
var root = new TreeNode(10);
root.setLeft(new TreeNode(20));
root.setRight(new TreeNode(30));
root.getLeft().setLeft(new TreeNode(40));
root.getLeft().setRight(new TreeNode(50));
root.getRight().setLeft(new TreeNode(50));
root.getRight().setRight(new TreeNode(60));
printLeftViewTree(root);
