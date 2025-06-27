import java.util.Scanner;

public class Row_With_Max1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the row size: ");
        int row = input.nextInt();
        System.out.print("Enter the column size: ");
        int col = input.nextInt();
        int[][] matrixArr = new int[row][col];

        // Fill the matrix with user input
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Enter element at (" + i + "," + j + "): ");
                matrixArr[i][j] = input.nextInt();
            }
        }
        input.close();

        // Print the matrix...
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrixArr[i][j] + " ");
            }
            System.out.println();
        }
        int[] result = rowAndMaximumOnes(matrixArr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    private static int[] rowAndMaximumOnes(int[][] mat) {
        int max = 0, index = 0;
        for (int i = 0; i < mat.length; i++) {
            int val = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    val++;
                }
            }
            if (max < val) {
                index = i;
                max = val;
            }
        }
        return new int[] { index, max };
    }
}
