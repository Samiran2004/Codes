import java.util.Scanner;

public class Maximum_Subarray_Sum {
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
        System.out.println("Result: "+ maxSubarraySum(arr));
    }

    private static long maxSubarraySum(int[] arr) {
        long sum = 0, maximum = Long.MIN_VALUE;

        if (arr.length == 0) {
            return sum;
        }

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum > maximum) {
                maximum = sum;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        return Math.max(0, maximum);
    }
}
