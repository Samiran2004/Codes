function rotate(nums: number[], k: number): void {
    let n: number = nums.length;
    let rotatedArr: number[] = [];
    for (let i: number = 0; i < n; i++) {
        rotatedArr[(i + k) % n] = nums[i];
    }
    for (let i: number = 0; i < n; i++) {
        arr[i] = rotatedArr[i];
    }
};

let arr: number[] = [1, 2, 3, 4, 5, 6, 7];
let k: number = 3;
console.log(arr);
rotate(arr, k);
console.log(arr);

export { };