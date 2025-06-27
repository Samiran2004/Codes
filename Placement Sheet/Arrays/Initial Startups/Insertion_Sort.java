import java.util.Arrays;
import java.util.Scanner;

public class Insertion_Sort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.printf("Enter %d number element: ", i + 1);
            arr[i] = input.nextInt();
        }
        input.close();

        System.out.println("Array before sorting using insertion sort algorithm: " + Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("Array after sorting using insertion sort algorithm: " + Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }
}
