import java.util.Scanner;

public class Matrix_Is_Symmetric {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the row size: ");
        int row = input.nextInt();
        System.out.print("Enter the column size: ");
        int column = input.nextInt();
        int[][] matrix = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.printf("Enter %d number row's and %d number column's element: ", i + 1, j + 1);
                matrix[i][j] = input.nextInt();
            }
        }
        input.close();
        System.out.println("The matrix is symmetric: " + isMatrixSymmetric(matrix));
    }

    private static boolean isMatrixSymmetric(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int[][] newMatrix = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                newMatrix[i][j] = matrix[j][i];
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (newMatrix[i][j] != matrix[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
