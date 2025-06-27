import java.util.Arrays;
import java.util.Scanner;

public class RotateAnArrayByK {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.printf("Enter %d number element of the array: ", i + 1);
            arr[i] = input.nextInt();
        }
        System.out.print("Enter the value of K: ");
        int k = input.nextInt();
        input.close();
        System.out.println(Arrays.toString(arr));
        rotate(arr, k);
        System.out.println(Arrays.toString(arr));
    }

    private static void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] rotatedArr = new int[n];
        for (int i = 0; i < n; i++) {
            rotatedArr[(i + k) % n] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = rotatedArr[i];
        }
    }
}