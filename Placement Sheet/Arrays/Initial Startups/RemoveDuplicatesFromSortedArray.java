import java.util.Scanner;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();

        int[] arr = new int[size];
        System.out.println("Please enter the array's values in sorted manner.");
        for (int i = 0; i < size; i++) {
            System.out.printf("Enter %d number element: ", i + 1);
            arr[i] = input.nextInt();
        }
        input.close();

        int result = removeDuplicates(arr);
        for (int i = 0; i < result; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static int removeDuplicates(int[] arr) {
        int count = 1;
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] != arr[i - 1]) {
                arr[count] = arr[i];
                count++;
            }
        }
        return count;
    }
}
