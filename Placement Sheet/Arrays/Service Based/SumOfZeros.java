import java.util.ArrayList;
import java.util.Scanner;

public class SumOfZeros {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the row size: ");
        int row = input.nextInt();
        System.out.print("Enter the column size: ");
        int column = input.nextInt();
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            ArrayList<Integer> currentRow = new ArrayList<>();
            for (int j = 0; j < column; j++) {
                System.out.printf("Enter %d number row's and %d number column's element: ", i + 1, j + 1);
                currentRow.add(input.nextInt());
            }
            matrix.add(currentRow);
        }
        input.close();

        System.out.println(coverageOfMatrix(matrix));
    }

    private static Integer coverageOfMatrix(ArrayList<ArrayList<Integer>> mat) {
        int coverage = 0;
        int m = mat.size();
        if (m == 0) {
            return 0;
        }
        int n = mat.get(0).size();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (mat.get(i).get(j) == 0) {
                    if (i - 1 >= 0 && mat.get(i - 1).get(j) == 1) {
                        coverage++;
                    }

                    if (i + 1 < m && mat.get(i + 1).get(j) == 1) {
                        coverage++;
                    }

                    if (j - 1 >= 0 && mat.get(i).get(j - 1) == 1) {
                        coverage++;
                    }

                    if (j + 1 < n && mat.get(i).get(j + 1) == 1) {
                        coverage++;
                    }
                }
            }
        }

        return coverage;
    }
}