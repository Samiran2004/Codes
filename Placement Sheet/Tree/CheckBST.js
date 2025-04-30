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
function isBST(node, min, max) {
    if (min === void 0) { min = -Infinity; }
    if (max === void 0) { max = Infinity; }
    if (!node) {
        return true;
    }
    var val = node.getData();
    if (val <= min || val >= max) {
        return false;
    }
    return isBST(node.getLeft(), min, val) && isBST(node.getRight(), val, max);
}
var root = new TreeNode(10);
var left = new TreeNode(5);
var right = new TreeNode(15);
root.setLeft(left);
root.setRight(right);
console.log(isBST(root));
