import java.util.Arrays;
import java.util.Scanner;

public class Cyclically_Rotate_an_Array_by_One {
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
        System.out.println("Original array: "+ Arrays.toString(arr));
        rotateArrayByOne(arr);
        System.out.println("Rotated array: "+ Arrays.toString(arr));
    }

    private static void rotateArrayByOne(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int prev = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            arr[i] = prev;
            prev = temp;
        }
        arr[0] = prev;
    }
}
