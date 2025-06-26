function rowAndMaximumOnes(mat: number[][]): number[] {
    let index: number = 0, max: number = 0;
    for (let i: number = 0; i < mat.length; i++) {
        let val: number = 0;
        for (let j: number = 0; j < mat[i].length; j++) {
            if (mat[i][j] == 1) {
                val++;
            }
        }
        if (val > max) {
            index = i;
            max = val;
        }
    }
    return [index, max];
};

// let mat: number[][] = [[0, 0, 0], [0, 1, 1]];
let mat: number[][] = [[0,0],[1,1],[0,0]];
console.log(rowAndMaximumOnes(mat));

export { };

//Time-Complexity :-> O(m * n);