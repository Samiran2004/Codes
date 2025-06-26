function checkPossibility(nums: number[]): boolean {
    let count: number = 0;
    for (let i: number = 0; i < nums.length - 1; i++) {
        if (nums[i] > nums[i + 1]) {
            count++;
            if (count > 1) {
                return false;
            }
            if (i > 0 && nums[i - 1] > nums[i + 1]) {
                nums[i + 1] = nums[i];
            } else {
                nums[i] = nums[i + 1];
            }
        }
    }
    return true;
};

let nums: number[] = [4, 2, 3];
console.log(checkPossibility(nums));

export{};