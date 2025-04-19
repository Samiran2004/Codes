"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var ParenthesisChecker = /** @class */ (function () {
    function ParenthesisChecker() {
    }
    ParenthesisChecker.prototype.isMatchingPair = function (open, close) {
        return ((open === '(' && close === ')') ||
            (open === '{' && close === '}') ||
            (open === '[' && close === ']'));
    };
    ParenthesisChecker.prototype.isBalanced = function (expression) {
        var stack = [];
        for (var _i = 0, expression_1 = expression; _i < expression_1.length; _i++) {
            var char = expression_1[_i];
            if (['(', '{', '['].includes(char)) {
                stack.push(char);
            }
            else if ([')', '}', ']'].includes(char)) {
                if (stack.length == 0 || !this.isMatchingPair(stack.pop(), char)) {
                    return false;
                }
            }
        }
        return stack.length === 0;
    };
    return ParenthesisChecker;
}());
var expression = "[{{()}}]";
var checker = new ParenthesisChecker();
var isBalanced = checker.isBalanced(expression);
isBalanced == true ? console.log("Expression is balanced...") : console.log("Expression is not balanced...");
