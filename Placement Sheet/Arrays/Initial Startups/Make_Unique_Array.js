"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
function minIncrementForUnique(nums) {
    nums.sort(function (a, b) { return a - b; });
    var count = 0;
    for (var i = 1; i < nums.length; i++) {
        if (nums[i] <= nums[i - 1]) {
            count += nums[i - 1] - nums[i] + 1;
            nums[i] = nums[i - 1] + 1;
        }
    }
    return count;
}
;
var nums = [3, 2, 1, 2, 1, 7];
console.log(minIncrementForUnique(nums));
