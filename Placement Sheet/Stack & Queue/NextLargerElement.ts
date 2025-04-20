class NextLargerElement {
    findNextGreater(arr: number[]): number[] {
        const result: number[] = new Array(arr.length).fill(-1);
        const stack: number[] = [];
        for (let i = 0; i < arr.length; i++) {
            while (stack.length > 0 && arr[i] > arr[stack[stack.length - 1]]) {
                const index = stack.pop()!;
                result[index] = arr[i];
            }
            stack.push(i);
        }
        return result;
    }
}

const arr: number[] = [4, 5, 2, 10, 8];
let nge = new NextLargerElement();
const result = nge.findNextGreater(arr);
console.log(result);

export { };