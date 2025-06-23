import java.util.ArrayList;
import java.util.Scanner;

public class Move_Zeros {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.printf("Enter %d number element of the array: ", i + 1);
            arr[i] = input.nextInt();
        }
        input.close();

        System.out.println("Before move zero: ");
        printArray(arr);

        int[] result = moveZerosBruteForce(arr);
        System.out.println("After move zero using brute-force method: ");
        printArray(result);

        System.out.print("After move zero using optimal approach: ");
        moveZeros(arr);
        printArray(arr);

    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Brute-Force
    private static int[] moveZerosBruteForce(int[] arr) {
        ArrayList<Integer> newArray = new ArrayList<>();
        ArrayList<Integer> zeroArray = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                newArray.add(arr[i]);
            } else {
                zeroArray.add(0);
            }
        }

        for (int i = 0; i < zeroArray.size(); i++) {
            newArray.add(zeroArray.get(i));
        }

        int[] result = new int[arr.length];
        for (int i = 0; i < newArray.size(); i++) {
            result[i] = newArray.get(i);
        }

        return result;
    }

    // Optimal
    private static void moveZeros(int[] arr) {
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[index] = arr[i];
                index++;
            }
        }

        while (index < arr.length) {
            arr[index] = 0;
            index++;
        }
    }
}
