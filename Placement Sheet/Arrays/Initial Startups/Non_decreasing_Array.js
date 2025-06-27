"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
function checkPossibility(nums) {
    var count = 0;
    for (var i = 0; i < nums.length - 1; i++) {
        if (nums[i] > nums[i + 1]) {
            count++;
            if (count > 1) {
                return false;
            }
            if (i > 0 && nums[i - 1] > nums[i + 1]) {
                nums[i + 1] = nums[i];
            }
            else {
                nums[i] = nums[i + 1];
            }
        }
    }
    return true;
}
;
var nums = [4, 2, 3];
console.log(checkPossibility(nums));
