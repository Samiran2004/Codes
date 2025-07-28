"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var MinStack = /** @class */ (function () {
    function MinStack() {
        this.stack = [];
        this.minStack = [];
    }
    //Push...
    MinStack.prototype.push = function (data) {
        this.stack.push(data);
        if (this.minStack.length == 0 || data <= this.getMin()) {
            this.minStack.push(data);
        }
    };
    //Pop...
    MinStack.prototype.pop = function () {
        var poppedElm = this.stack.pop();
        if (poppedElm === this.getMin()) {
            this.minStack.pop();
        }
        return poppedElm;
    };
    //Peek...
    MinStack.prototype.peek = function () {
        return this.stack[this.stack.length - 1];
    };
    MinStack.prototype.getMin = function () {
        return this.minStack[this.minStack.length - 1];
    };
    return MinStack;
}());
var minStack = new MinStack();
minStack.push(5);
minStack.push(3);
minStack.push(7);
minStack.push(2);
console.log("Min: ".concat(minStack.getMin()));
minStack.pop();
console.log("Min: ".concat(minStack.getMin()));
console.log("Top: ".concat(minStack.peek()));
