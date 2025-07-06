import java.util.Scanner;

public class Non_Decreasing_Array {
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
        System.out.println("Array is non-decreasing: " + isPossible(arr, size));
    }

    private static boolean isPossible(int[] arr, int n) {
        if (arr.length == 0) {
            return false;
        }

        boolean changed = false;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] <= arr[i + 1]) {
                continue;
            }
            if (changed) {
                return false;
            }

            if (i == 0 || arr[i + 1] >= arr[i - 1]) {
                arr[i] = arr[i + 1];
            } else {
                arr[i + 1] = arr[i];
            }

            changed = true;
        }

        return true;
    }
}