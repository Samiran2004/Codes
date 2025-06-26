function minIncrementForUnique(nums: number[]): number {
    nums.sort((a: number, b: number) => a - b);
    let count: number = 0;
    for (let i: number = 1; i < nums.length; i++) {
        if (nums[i] <= nums[i - 1]) {
            count += nums[i - 1] - nums[i] + 1;
            nums[i] = nums[i - 1] + 1;
        }
    }
    return count;
};

let nums: number[] = [3, 2, 1, 2, 1, 7];
console.log(minIncrementForUnique(nums));

export { };