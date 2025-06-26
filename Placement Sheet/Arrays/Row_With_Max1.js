"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
function rowAndMaximumOnes(mat) {
    var index = 0, max = 0;
    for (var i = 0; i < mat.length; i++) {
        var val = 0;
        for (var j = 0; j < mat[i].length; j++) {
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
}
;
// let mat: number[][] = [[0, 0, 0], [0, 1, 1]];
var mat = [[0, 0], [1, 1], [0, 0]];
console.log(rowAndMaximumOnes(mat));
