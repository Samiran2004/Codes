public class Matrix_Is_Symmetric {
    public static void main(String[] args) {
        int[][] matrix1 = {
                { 1, 2, 3 },
                { 2, 4, 5 },
                { 3, 5, 8 }
        };

        if (checkSymmetricMatrixBruteForce(matrix1)) {
            System.out.println("Matrix is symmetric");
        } else {
            System.out.println("Matric is not symmetric");
        }
    }

    // Brute-Force
    private static boolean checkSymmetricMatrixBruteForce(int[][] matrix1) {
        int[][] newMatrix = new int[matrix1[0].length][matrix1.length];
        for (int i = 0; i < matrix1[0].length; i++) {
            for (int j = 0; j < matrix1.length; j++) {
                newMatrix[i][j] = matrix1[j][i];
            }
        }
        for (int i = 0; i < matrix1[0].length; i++) {
            for (int j = 0; j < matrix1.length; j++) {
                if (matrix1[i][j] != newMatrix[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // Optimal
    private static boolean checkSymmetricMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            if (matrix[i].length != n) {
                return false;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                }
            }
        }
        return true;
    }
}
