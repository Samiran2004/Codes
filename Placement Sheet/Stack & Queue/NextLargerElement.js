"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var NextLargerElement = /** @class */ (function () {
    function NextLargerElement() {
    }
    NextLargerElement.prototype.findNextGreater = function (arr) {
        var result = new Array(arr.length).fill(-1);
        var stack = [];
        for (var i = 0; i < arr.length; i++) {
            while (stack.length > 0 && arr[i] > arr[stack[stack.length - 1]]) {
                var index = stack.pop();
                result[index] = arr[i];
            }
            stack.push(i);
        }
        return result;
    };
    return NextLargerElement;
}());
var arr = [4, 5, 2, 10, 8];
var nge = new NextLargerElement();
var result = nge.findNextGreater(arr);
console.log(result);
