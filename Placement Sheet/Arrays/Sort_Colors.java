import java.util.Arrays;
import java.util.Scanner;

public class Sort_Colors {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.printf("Enter %d number element: ", i + 1);
            arr[i] = input.nextInt();
        }

        System.out.print("Before sorting: ");
        System.out.println(Arrays.toString(arr));

        System.out.print("After sorting using bruteforce method: ");
        sortColorsBruteForce(arr);
        System.out.println(Arrays.toString(arr));

        System.out.print("After sorting using optimized method: ");
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }

    // Brute-Force
    private static void sortColorsBruteForce(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    private static void sortColors(int[] nums) {
        int minIndex;
        for (int i = 0; i < nums.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }
    }
}
