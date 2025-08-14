import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.printf("Enter %d number element of the array: ", i + 1);
            arr[i] = input.nextInt();
        }

        System.out.print("Enter the element to search: ");
        int target = input.nextInt();

        input.close();

        System.out.println(search(arr, target));
    }

    private static int search(int[] arr, int target) {
        if (arr.length == 0) {
            return -1;
        }

        Arrays.sort(arr);

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (target > arr[mid]) {
                start = mid + 1;
            }
            if (target <= arr[mid]) {
                end = mid - 1;
            }
        }

        return -1;
    }
}
