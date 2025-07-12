import java.util.Scanner;

public class Search_In_Rotated_Sorted_Array {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.printf("Enter the %d number element of the array: ", i + 1);
            arr[i] = input.nextInt();
        }

        System.out.print("Enter the key value: ");
        int key = input.nextInt();

        input.close();

        System.out.println("Result: " + search(arr, key));
    }

    private static int search(int[] arr, int key) {
        if (arr.length == 0) {
            return -1;
        }

        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == key) {
                return mid;
            } else {
                if (arr[mid] >= arr[low]) {
                    if (key >= arr[low] && key < arr[mid]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                } else {
                    if (key <= arr[high] && key > arr[mid]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
        }

        return -1;
    }
}
