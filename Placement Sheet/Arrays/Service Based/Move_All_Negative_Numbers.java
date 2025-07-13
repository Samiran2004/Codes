import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Move_All_Negative_Numbers {
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

        System.out.println("Original Array: " + Arrays.toString(arr));

        System.out.println("After moving: " + Arrays.toString(separateNegativeAndPositive(arr)));
    }

    /*
     * Time complexity: O(n)
     * Space complexity O(n)
     */
    // private static int[] separateNegativeAndPositive(int[] arr) {
    // if (arr.length == 0) {
    // return null;
    // }
    // ArrayList<Integer> positiveList = new ArrayList<>();
    // ArrayList<Integer> negativeList = new ArrayList<>();
    // ArrayList<Integer> result = new ArrayList<>();

    // for (int i = 0; i < arr.length; i++) {
    // if (arr[i] < 0) {
    // negativeList.add(arr[i]);
    // } else {
    // positiveList.add(arr[i]);
    // }
    // }

    // result.addAll(negativeList);
    // result.addAll(positiveList);

    // Integer[] temp = result.toArray(new Integer[0]);
    // int[] finalResult = new int[temp.length];
    // for (int i = 0; i < temp.length; i++) {
    // finalResult[i] = temp[i];
    // }
    // return finalResult;
    // }

    private static int[] separateNegativeAndPositive(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            if (arr[left] < 0) {
                left++;
            } else if (arr[right] >= 0) {
                right--;
            } else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }
        }

        return arr;
    }
}
