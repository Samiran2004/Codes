"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
function rotate(nums, k) {
    var n = nums.length;
    var rotatedArr = [];
    for (var i = 0; i < n; i++) {
        rotatedArr[(i + k) % n] = nums[i];
    }
    for (var i = 0; i < n; i++) {
        arr[i] = rotatedArr[i];
    }
}
;
var arr = [1, 2, 3, 4, 5, 6, 7];
var k = 3;
console.log(arr);
rotate(arr, k);
console.log(arr);
