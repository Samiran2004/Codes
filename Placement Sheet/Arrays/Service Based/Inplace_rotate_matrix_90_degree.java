import java.util.Arrays;
import java.util.Scanner;

public class Inplace_rotate_matrix_90_degree {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of the row: ");
        int row = input.nextInt();
        System.out.print("Enter the size of the column: ");
        int column = input.nextInt();

        int[][] matrix = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.printf("Enter element at row %d and column %d: ", i + 1, j + 1);
                matrix[i][j] = input.nextInt();
            }
        }
        input.close();

        System.out.println("Input matrix:");
        for (int i = 0; i < row; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    // private static
}